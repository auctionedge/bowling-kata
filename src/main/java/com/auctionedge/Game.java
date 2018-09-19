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
        Swing curSwing = curFrame.getCurSwing();
        int pinsUp = pins.getPinsUp();

        score += down;
        System.out.format("score increase: score %d\n", score);

        if (frames.getPrevFrame() != null && frames.getPrevFrame().isStrike()) {
            score += down;
            System.out.format("score increase: strike prev: score %d\n", score);
        }

        if (frames.getPrevPrevFrame() != null && frames.getPrevPrevFrame().isStrike()) {
            score += down;
            System.out.format("score increase: strike prev prev: score %d\n", score);
        }

        if (frames.getPrevFrame() != null && frames.getPrevFrame().isSpare()) {
            score += down;
            System.out.format("score increase: spare prev: score %d\n", score);
        }

        if (pinsUp == 0) {
            if (curFrame.isFirstSwing()) {
                curFrame.setStrike();
                pins.set();
                return frames.incIdx();
            }
            else if (curFrame.isSecondSwing()) {
                curFrame.setSpare();
            }
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
