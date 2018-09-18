package com.auctionedge;

public class Frame {

    private Swing swings[];
    private int curSwingIdx;
    private boolean strike;
    private boolean spare;

    public Frame() {
        swings = new Swing[2];
        for (Swing swing : swings) {
            swing = new Swing();
        }
        curSwingIdx = 0;
        strike = false;
        spare = false;
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

    public void setStrike() {
        strike = true;
    }

    public void setSpare() {
        spare = true;
    }

    public boolean isStrike() {
        return strike;
    }
    public boolean isSpare() {
        return spare;
    }
}
