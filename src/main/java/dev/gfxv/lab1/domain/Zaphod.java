package dev.gfxv.lab1.domain;

public class Zaphod {

    private final Emotion emotion;
    private double speed;

    public static final double fastSpeed = 10;

    public Zaphod(Emotion emotion, double speed) {
        this.emotion = emotion;
        setSpeed(speed);
    }

    public String walk() {
        if (speed >= fastSpeed) {
            return "Zaphod is walking fast!";
        } else {
            return "Zaphod is walking";
        }
    }

    public Emotion getEmotion() {
        // Он сильно нервничал, но пытался скрыть это за целеустремленностью.
        if (emotion.equals(Emotion.NERVOUS)) {
            return Emotion.DETERMINISTIC;
        }
        return emotion;
    }

    public void setSpeed(double speed) {
        if (speed < 0) {
            throw new IllegalArgumentException("Speed is negative");
        }
        this.speed = speed;
    }
}
