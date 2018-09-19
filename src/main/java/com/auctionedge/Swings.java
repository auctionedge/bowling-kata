package com.auctionedge;

public class Swings {
    private Swing swings[];
    private static final int INITIAL_MAX_SWINGS = 2;
    private int maxSwings;
    private int curIdx;

    public Swings() {
        swings = new Swing[2];
        for (int i = 0; i < swings.length; i++) {
            swings[i] = new Swing();
        }
        maxSwings = INITIAL_MAX_SWINGS;
        curIdx = 0;
    }

   public boolean incIdx(Frame frame) {
        if (curIdx < maxSwings - 1) {
            curIdx++;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isFirst() {
        return curIdx == 0;
    }

    public void decreaseMaxSwing() {
        maxSwings -= 1;
    }
}
