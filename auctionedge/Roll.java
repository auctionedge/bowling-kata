package com.auctionedge;

/**
 * Class that represents one roll.  A roll is only responsible for itself.
 */
public class Roll implements Scoring {
    public final static int MAX_SCORE = 10; // 10 pins, does not include any bonuses
    private final int score;

    public Roll(int score) {
        this.score = score;
    }

    @Override
    public int getScore() {
        // returns the score for this roll only
        return score;
    }

    @Override
    public String toString() {
        return Integer.toString(score);
    }
}
