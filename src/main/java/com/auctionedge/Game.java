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
        Swing curSwing = curFrame.getCurSwing();
        int pinsUp = pins.getPinsUp();

        score += down;

        if (frames.getPrevFrame() != null && frames.getPrevFrame().isStrike()) {
            score += down;
        }

        if (frames.getPrevPrevFrame() != null && frames.getPrevPrevFrame().isStrike()) {
            score += down;
        }

        if (frames.getPrevFrame() != null && frames.getPrevFrame().isSpare()) {
            score += down;
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

        if (curFrame.incSwingIdx(frames.getCurIdx()))
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
