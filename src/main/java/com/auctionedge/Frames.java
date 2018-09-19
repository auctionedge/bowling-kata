package com.auctionedge;

public class Frames {
    private Frame[] frames;
    public static final int INITIAL_MAX_FRAMES = 10;
    private int maxFrames;
    private int curFrameIdx;

    public Frames() {
        frames = new Frame[12];
        for (int i = 0; i < frames.length; i++) {
            frames[i] = new Frame(i);
        }
        maxFrames = INITIAL_MAX_FRAMES;
        curFrameIdx = 0;
    }

    public boolean incIdx() {
        System.out.format("1 curFrameIdx: %d maxFrames %d\n", curFrameIdx, maxFrames);

        if (curFrameIdx == INITIAL_MAX_FRAMES - 1) {
            if (getCurFrame().isSpare()) {
                maxFrames += 1;
                getNextFrame().decreaseMaxSwing();
            }
            else if (getCurFrame().isStrike()) {
                maxFrames += 1;
            }
        }

        System.out.format("1 curFrameIdx: %d maxFrames %d\n", curFrameIdx, maxFrames);

        if (curFrameIdx == INITIAL_MAX_FRAMES) {
            if (getCurFrame().isStrike()) {
                maxFrames += 1;
                getNextFrame().decreaseMaxSwing();
            }
        }

        System.out.format("2 curFrameIdx: %d maxFrames %d\n", curFrameIdx, maxFrames);

        if (curFrameIdx < maxFrames - 1) {
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

    private Frame getNextFrame() {
        return frames[curFrameIdx + 1];
    }

    private Frame getNextNextFrame() {
        return frames[curFrameIdx + 2];
    }
}
