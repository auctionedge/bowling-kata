package com.auctionedge;

public class Game {
    private Frames frames;
    private int score;
    private boolean gameOver;
    private Pins pins;

    public Game() {
        frames = new Frames();
        score = 0;
        gameOver = false;
        pins = new Pins();
        pins.set();
    }

    public boolean swing(int down) {
        if (gameOver)
            return false;

        if (pins.whack(down) == false)
            return false;

        Frame curFrame = frames.getCurFrame();
        Swing curSwing = curFrame.getCurSwing();
        int pinsUp = pins.getPinsUp();

        if (curFrame.getCurSwingIdx() == 0) {
            if (pinsUp == 0) {
                curFrame.setStrike();
            }
            else {
                curFrame.setSpare();
            }
        }
        else {

        }
        if (curFrame.incSwingIdx())
            return true;
        else
            return frames.incIdx();
    }

    public int getPinsLeft() {
        return pins.getPinsUp();
    }


    public int getScore() {
        return score;
    }
}
