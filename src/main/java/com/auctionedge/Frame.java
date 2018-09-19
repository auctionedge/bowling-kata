package com.auctionedge;

public class Frame {
    private int frameIdx;
    private Swings swings;
    private int score;
    private boolean strike;
    private boolean spare;

    public Frame(int frameIdx) {
        this.frameIdx = frameIdx;
        swings = new Swings();
        strike = false;
        spare = false;
    }

    public int getCurIdx() {
        return frameIdx;
    }

    public Swing getCurSwing() {
        return swings.getCur();
    }

    public boolean incSwingIdx(Frame frame) {
        return swings.incIdx(frame);
    }

    public boolean isFirstSwing() {
        return swings.isFirst();
    }

    public boolean isSecondSwing() {
        return swings.isSecond();
    }

    public void setStrike() {
        strike = true;
    }

    public boolean isStrike() {
        return strike;
    }

    public void setSpare() {
        spare = true;
    }

    public boolean isSpare() {
        return spare;
    }

    public void decreaseMaxSwing() {
        swings.decreaseMaxSwing();
    }
}
