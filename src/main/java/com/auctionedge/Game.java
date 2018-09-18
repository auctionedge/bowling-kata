package com.auctionedge;

public class Game {
    private Pins pins;
    private Frame[] frames;
    private int curFrameIdx;
    private int score;
    private boolean gameOver;

    public Game() {
        pins = new Pins();
        frames = new Frame[10];
        for (int i = 0; i < frames.length; i++) {
            frames[i] = new Frame();
        }
        curFrameIdx = 0;
        score = 0;
        gameOver = false;
    }

    public boolean swing(int down) {
        if (gameOver)
            return false;

        if (pins.whack(down) == false)
            return false;

        if (frames[curFrameIdx].incSwingIdx())
            return true;
        else
            return incFrameIdx();
    }

    public int getPinsLeft() {
        return pins.getPinsUp();
    }

    public int getCurFrameIdx() {
        return curFrameIdx;
    }

    public boolean incFrameIdx() {
        if (curFrameIdx < frames.length - 1) {
            curFrameIdx++;
            return true;
        }
        else {
            gameOver = true;
            return false;
        }
    }

    public int getPrevFrameIdx() {
        if (curFrameIdx - 1 >= 0)
            return curFrameIdx - 1;
        else
            return -1;
    }

    public int getPrevPrevFrameIdx() {
        if (curFrameIdx - 2 >= 0)
            return curFrameIdx - 2;
        else
            return -1;
    }

    public int getScore() {
        return score;
    }
}
