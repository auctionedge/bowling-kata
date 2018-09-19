package com.auctionedge;

public class Frames {
    private Frame[] frames;
    private int curFrameIdx;

    public Frames() {
        frames = new Frame[10];
        for (int i = 0; i < frames.length; i++) {
            frames[i] = new Frame(i);
        }
        curFrameIdx = 0;
    }

    public boolean incIdx() {
        System.out.format("curFrameIdx: %d frames.length %d\n", curFrameIdx, frames.length);
        if (curFrameIdx < frames.length - 1) {
            curFrameIdx++;
            return true;
        } else {
            return false;
        }
    }

    public Frame getCurFrame() {
        return frames[curFrameIdx];
    }

    public Frame getPrevFrame() {
        if (curFrameIdx - 1 >= 0)
            return frames[curFrameIdx - 1];
        else
            return null;
    }

    public Frame getPrevPrevFrame() {
        if (curFrameIdx - 2 >= 0)
            return frames[curFrameIdx - 2];
        else
            return null;
    }

    public int getCurIdx() {
        return curFrameIdx;
    }
}
