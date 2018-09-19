package com.auctionedge;

import java.util.List;

public class BowlingGame {

    private Game game;

    public BowlingGame() {
        game = new Game();
    }

	public void rolls(List<Integer> theRolls) {
        for (Integer pinsDown : theRolls) {
            System.out.format("pinsDown: %d\n", pinsDown);
            boolean valid = game.swing(pinsDown);
            System.out.format("valid: %b\n", valid);
            System.out.format("pinsLeft: %d\n", game.getPinsLeft());
            if (! valid) {
                System.out.format("Game Over!\n");
                break;
            }
        }
	}

	public int score() {
		return game.getScore();
	}
}
