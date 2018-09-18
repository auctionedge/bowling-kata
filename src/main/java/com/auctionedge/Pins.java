package com.auctionedge;

public class Pins {
    private int pinsUp;
    private int pinsDown;

    public Pins() {
        pinsUp = 10;
        pinsDown = 0;
    }

    public boolean whack(int down) {
        if (down < 0 || down > pinsUp)
            return false;

        pinsUp -= down;
        pinsDown += down;
        return true;
    }

    public int getPinsUp() {
        return pinsUp;
    }
}
