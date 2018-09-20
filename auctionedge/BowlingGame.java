package com.auctionedge;

import java.util.List;

/**
 * Class that will score a game of bowling.
 *
 * How do you score a game of bowling?  I'm glad you asked.
 * - All bowlers get to roll up to 10 frames.  However, the 10th frame is only available to those who spare or
 * strike in 9th frame.
 * - Each frame gets up to two rolls.  If a player strikes, then they don't get an additional roll in the
 * current frame because they've destroyed all the pins
 * Let F = current frame, R = current roll
 * -- foreach roll
 * -- if the player strikes
 * --- then their score will be (F - 1) + 10 + (R + 1) + (R + 2)
 * -- if the player does not strike
 * --- then they take their 2nd roll
 * ---- if the player spares
 * ----- then their score will be (F - 1) + 10 + (R + 1)
 * ---- else
 * ----- their score will be (F - 1) + (R - 1) + R
 */
public class BowlingGame {
    private Game game;
    private final GameFactory gameFactory;

    public BowlingGame() {
        this.gameFactory = new GameFactory();
    }

    public void rolls(List<Integer> theRolls) {
        this.game = gameFactory.create(theRolls);
    }

    public int score() {
        if (game != null) {
            return game.getScore();
        }
        return 0;
    }
}
