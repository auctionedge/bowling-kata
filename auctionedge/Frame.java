package com.auctionedge;

/**
 * Class that represents a frame.  A frame is responsible for talking to sibling frames and calculating frame score.
 */
public class Frame implements Scoring {
    private FrameState frameState;
    private Roll firstRoll;
    private Roll secondRoll;
    private Frame nextFrame;

    public Frame getNextFrame() {
        return nextFrame;
    }

    public void setNextFrame(Frame nextFrame) {
        this.nextFrame = nextFrame;
    }

    public boolean isStrike() {
        return frameState == FrameState.STRIKE;
    }

    public boolean isSpare() {
        return frameState == FrameState.SPARE;
    }

    public void setFrameState(FrameState frameState) {
        this.frameState = frameState;
    }

    public Roll getFirstRoll() {
        return firstRoll;
    }

    public void setFirstRoll(Roll firstRoll) {
        this.firstRoll = firstRoll;
    }

    public Roll getSecondRoll() {
        return secondRoll;
    }

    public void setSecondRoll(Roll secondRoll) {
        this.secondRoll = secondRoll;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (firstRoll != null) {
            builder.append("First roll has a score of ").append(firstRoll.toString());

            // can't have a second roll without a first!
            if (secondRoll != null) {
                builder.append("/nSecond roll has a score of ").append(secondRoll.toString());
            }
        }

        return builder.toString();
    }

    @Override
    public int getScore() {
        // calculates total score for the frame
        int totalScore;

        if (isStrike()) { // check for a strike
            totalScore = calculateStrikeTotal();
        } else if (isSpare()) { // check for spare
            totalScore = calculateSpareTotal();
        } else {
            // else use the sum of first and second roll
            totalScore = calculateSumOfBothRolls();
        }

        return totalScore;
    }

    private int calculateSumOfBothRolls() {
        int totalScore;
        totalScore = firstRoll.getScore();

        if (secondRoll != null) {
            totalScore += secondRoll.getScore();
        }
        return totalScore;
    }

    private int calculateSpareTotal() {
        int totalScore = 0;

        if (nextFrame == null) {
            totalScore += getFirstRoll().getScore();
        } else {
            totalScore = Roll.MAX_SCORE;
            // add next roll
            if (nextFrame.isStrike() || nextFrame.isSpare()) {
                // add max score for either bonus
                totalScore += Roll.MAX_SCORE;
            } else {
                // add next roll
                totalScore += nextFrame.getFirstRoll().getScore();
            }
        }
        return totalScore;
    }

    private int calculateStrikeTotal() {
        // base score
        int totalScore = 0;

        if (nextFrame.getNextFrame() != null) {
            totalScore += Roll.MAX_SCORE;
            // get next roll
            if (nextFrame.isStrike()) {
                totalScore += Roll.MAX_SCORE;

                // perfect frame
                if (nextFrame.getNextFrame().isStrike()) {
                    totalScore += Roll.MAX_SCORE;
                } else {
                    // add value of the roll
                    totalScore += nextFrame.getNextFrame().getFirstRoll().getScore();
                }
            } else {
                // otherwise just get the next two rolls from the next frame
                totalScore += nextFrame.getFirstRoll().getScore();
                totalScore += nextFrame.getSecondRoll().getScore();
            }
        }
        return totalScore;
    }
}
