package com.auctionedge;

import com.auctionedge.utils.CollectionUtils;

import java.util.List;

/**
 * Factory to create bowling game.
 * TODO: this is too much business logic for a factory, some of this would be moved into a service if I had more time
 */
public class GameFactory {
    private final Game game;

    public GameFactory() {
        this.game = new Game();
    }

    // create a game from a list of rolls
    public Game create(final List<Integer> rolls) {
        if (CollectionUtils.isNullOrEmpty(rolls)) {
            throw new IllegalArgumentException("Cannot create a game, there are no rolls!");
        }

        // 2 rolls per frame, 10 frames and 1 bonus roll
        int MAX_ROLLS_PER_GAME = 10 * 2 + 1;
        if (rolls.size() > MAX_ROLLS_PER_GAME) {
            throw new IllegalArgumentException("Cannot create a game, there are too many rolls!");
        }

        // each iteration will start at the beginning of each frame
        Frame currentFrame = null;
        int frameCount = 0;
        for(int rollCount = 0; rollCount < rolls.size();rollCount++) {
            // get the first roll in the frame
            final Integer firstRoll = rolls.get(rollCount);

            if (firstRoll != null) {
                // initialize the first frame
                if (currentFrame == null) {
                    currentFrame = new Frame();
                }

                if (!isValidRoll(firstRoll)) {
                    throw new IllegalArgumentException("Invalid roll:" + firstRoll);
                }

                // check if we have a strike
                currentFrame.setFirstRoll(new Roll(firstRoll));

                if(firstRoll == Roll.MAX_SCORE) {
                    currentFrame.setFrameState(FrameState.STRIKE);
                }else {
                    // we're at the end, break
                    if (rollCount == rolls.size() - 1) {
                        break;
                    }

                    // if roll is not a strike, move onto the next roll in the frame
                    rollCount++;

                    final Integer secondRoll = rolls.get(rollCount);
                    if (!isValidRoll(secondRoll)) {
                        throw new IllegalArgumentException("Invalid roll:" + secondRoll);
                    }

                    currentFrame.setSecondRoll(new Roll(secondRoll));

                    // if we're in the 2nd roll, and the sum of both rolls is the max, then it was a spare
                    if (firstRoll + secondRoll == Roll.MAX_SCORE) {
                        currentFrame.setFrameState(FrameState.SPARE);
                    }
                }

                final Frame nextFrame;
                if (frameCount <= Game.MAX_FRAMES_PER_GAME) {
                    nextFrame = new Frame();
                    // Create the next frame, since we're finished with the current one
                    currentFrame.setNextFrame(nextFrame);
                    frameCount++;

                    // add the frame to the game
                    game.addFrame(currentFrame);
                    currentFrame = currentFrame.getNextFrame();
                }
            } else {
                throw new IllegalArgumentException("Cannot have a null score!");
            }
        }

        return game;
    }

    private boolean isValidRoll(final int score) {
        return score >= 0 && score <= Roll.MAX_SCORE;
    }
}
