package com.auctionedge;

public class Swing {
    private int idx;
    private boolean strike;

    public Swing(int idx) {
        this.idx = idx;
        strike = false;
    }

    public void setStrike() {
        strike = true;
    }

     public boolean isStrike() {
        return strike;
    }

}
