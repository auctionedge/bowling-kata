package com.auctionedge;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents an entire game of bowling
 */
public class Game implements Scoring {
    public static final int MAX_FRAMES_PER_GAME = 10; // 10 base frames, plus a bonus
    private final List<Frame> frames;

    public Game() {
        this.frames = new ArrayList<>();
    }

    public void addFrame(final Frame frame) {
        if (frame != null && frames.size() <= MAX_FRAMES_PER_GAME) {
            // if we've completed a frame, add it to the game
            frames.add(frame);
        } else {
            throw new IllegalArgumentException("Invalid number of frames or rolls");
        }
    }

    @Override
    public int getScore() {
        // calculate total score for the entire game
        int totalScore = 0;

        for (Frame frame : frames) {
            totalScore += frame.getScore();
        }

        return totalScore;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Frame frame : frames) {
            builder.append(frame.toString()).append("/n");
        }

        return builder.toString();
    }
}
