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
        System.out.format("do swing: pinsUp: %d\n", pinsUp);

        if (pinsUp == 0) {
            if (curFrame.isFirstSwing()) {
                curFrame.setStrike();
                System.out.format("Is strike\n");
            }
            else {
                curFrame.setSpare();
                System.out.format("Is spare\n");
            }
        }

        if (curFrame.getCurIdx() < Frames.INITIAL_MAX_FRAMES) {
            score += down;
            System.out.format("score increase: score %d\n", score);
        }

        if ((frames.getPrevFrame() != null && frames.getPrevFrame().isStrike()) &&
            curFrame.getCurIdx() != Frames.INITIAL_MAX_FRAMES + 1) {
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
