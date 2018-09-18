package com.auctionedge;

public class Frame {
    private int frameIdx;
    private Swings swings;
    private int score;

    public Frame(int frameIdx) {
        this.frameIdx = frameIdx;
        swings = new Swings();
        score = 0;
    }

    public Swing getCurSwing() {
        return swings.getCurSwing();
    }

    public void increaseScore(int amount) {
        score += amount;
    }

    public int getScore() {
        return score;
    }
}
