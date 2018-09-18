package com.auctionedge;

public class Pins {
    private int pinsUp;

    public Pins() {
        set();
    }

    public void set() {
        pinsUp = 10;
    }

    public boolean whack(int down) {
        if (down < 0 || down > pinsUp)
            return false;

        pinsUp -= down;
        return true;
    }

    public int getPinsUp() {
        return pinsUp;
    }
}
