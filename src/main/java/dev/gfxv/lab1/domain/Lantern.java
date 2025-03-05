package dev.gfxv.lab1.domain;

public class Lantern {
    private boolean on;

    public Lantern() {
        this.on = false;
    }

    public boolean switchLantern() {
        on = !on;
        return on;
    }

    public boolean getState() {
        return on;
    }
}
