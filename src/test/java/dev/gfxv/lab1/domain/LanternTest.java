package dev.gfxv.lab1.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LanternTest {

    @Test
    void testSwitch() {
        Lantern lantern = new Lantern();
        boolean currentState = lantern.getState();
        boolean status = lantern.switchLantern();
        assertEquals(!currentState, status);
    }

}