package com.auctionedge;

public class Frame {
    private Swing swings[];
    private int curSwingIdx;
    private int score;

    public Frame() {
        swings = new Swing[2];
        for (int i = 0; i < swings.length; i++) {
            swings[i] = new Swing();
        }
        curSwingIdx = 0;
        score = 0;
    }

    public int getCurSwingIdx() {
        return curSwingIdx;
    }

    public boolean incSwingIdx() {
        if (curSwingIdx < swings.length - 1) {
            curSwingIdx ++;
            return true;
        }
        else {
            return false;
        }

    }

    public void increaseScore(int amount) {
        score += amount;
    }

    public int getScore() {
        return score;
    }
}
