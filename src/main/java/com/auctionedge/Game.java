package com.auctionedge;

public class Game {
    private Frames frames;
    private int score;
    private Pins pins;

    public Game() {
        frames = new Frames();
        score = 0;
        pins = new Pins();
        pins.set();
    }

    public boolean swing(int down) {
        if (pins.whack(down) == false)
            return false;

        Frame curFrame = frames.getCurFrame();
        System.out.format("do swing: frame idx: %d down: %d\n", curFrame.getCurIdx(), down);
        int pinsUp = pins.getPinsUp();

        score += down;
        System.out.format("score increase: score %d\n", score);

        if (curFrame.isFirstSwing() && pinsUp == 0)
            curFrame.setStrike();
        else
            curFrame.setSpare(); // NOTICE: Definition of space is not conventional one, should refactor this

        if (frames.getPrevFrame() != null && frames.getPrevFrame().isStrike()) {
            score += down;
            System.out.format("score increase: prev strike: score %d\n", score);
        }

        if ((frames.getPrevPrevFrame() != null && frames.getPrevPrevFrame().isStrike()) &&
            (curFrame.isStrike() && frames.getPrevFrame().isStrike() ||
             curFrame.isSpare() && curFrame.isFirstSwing() && frames.getPrevFrame().isStrike())) {
            score += down;
            System.out.format("score increase: prev prev score %d\n", score);
        }

        if ((frames.getPrevFrame() != null && frames.getPrevFrame().isSpare()) &&
            curFrame.isFirstSwing()) {
            score += down;
            System.out.format("score increase: prev: score %d\n", score);
        }

        if (curFrame.isStrike()) {
            pins.set();
            return frames.incIdx();
        }

        if (curFrame.incSwingIdx(curFrame))
            return true;
        else {
            pins.set();
            return frames.incIdx();
        }
    }

    public int getPinsLeft() {
        return pins.getPinsUp();
    }

    public int getScore() {
        return score;
    }
}
