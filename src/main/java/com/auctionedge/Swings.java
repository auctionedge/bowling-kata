package com.auctionedge;

public class Swings {
    private Swing swings[];
    private int curIdx;

    public Swings() {
        swings = new Swing[3];
        for (int i = 0; i < swings.length; i++) {
            swings[i] = new Swing(i);
        }
        curIdx = 0;
    }

    public Swing getCur() {
        return swings[curIdx];
    }

    public boolean incIdx(int frameIdx) {
        if (frameIdx < 9) {
            if (curIdx < swings.length - 2) {
                curIdx++;
                return true;
            }
            else {
                return false;
            }
        }
        else {
            if (curIdx < swings.length - 1) {
                curIdx++;
                return true;
            }
            else {
                return false;
            }
        }

    }

    public boolean isFirst() {
        return curIdx == 0;
    }

    public boolean isSecond() {
        return curIdx == 1;
    }
}