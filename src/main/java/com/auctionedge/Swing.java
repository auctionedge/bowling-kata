package com.auctionedge;

public class Swing {
    private int pinsUp;
    private int pinsDown;

    public Swing() {
        pinsUp = 10;
        pinsDown = 0;
    }

    public void fall(int down) {
        pinsUp -= down;
        pinsDown += down;
    }
}
