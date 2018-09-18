package com.auctionedge;

public class Swings {
    private Swing swings[];
    private int curSwingIdx;

    public Swings() {
        swings = new Swing[3];
        for (int i = 0; i < swings.length; i++) {
            swings[i] = new Swing(i);
        }
        curSwingIdx = 0;
    }

    public Swing getCurSwing() {
        return swings[curSwingIdx];
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
}
