package com.auctionedge;

import java.util.List;

public class BowlingGame {

	private int score = 0;

	public void rolls(List<Integer> theRolls) {
	    score = 0;
        for (Integer roll : theRolls) {
            System.out.format("roll: %d\n", roll);
            score += roll;
        }
	}

	public int score() {
		return score;
	}
}
