package com.auctionedge;

import java.util.List;

public class BowlingGame {

    private int score;
    private Game game;

    public BowlingGame() {
        score = 0;
        game = new Game();
    }

	public void rolls(List<Integer> theRolls) {
        for (Integer pinsDown : theRolls) {
            System.out.format("pinsDown: %d\n", pinsDown);
            boolean valid = game.swing(pinsDown);
            System.out.format("valid: %b\n", valid);
            System.out.format("pinsLeft: %d\n", game.getPinsLeft());
        }
	}

	public int score() {
		return game.getScore();
	}
}
