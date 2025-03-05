package dev.gfxv.lab1.domain;

public class Wall {
    private final double coldTemperature = 15;
    private final double hotTemperature = 30;

    public static final double lowestTemperature = -459.67;
    public static final double highestTemperature = 120;


    private Material material;
    private double temperature;

    // TODO: add temperature validation
    public Wall(Material material, double temperature) {
        setTemperature(temperature);
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }

    public String getTemperature() {
        if (temperature <= coldTemperature) {
            return "Wall is cold!";
        } else if (temperature >= hotTemperature) {
            return "Wall is hot!";
        } else {
            return "Wall is fine";
        }
    }

    public void setTemperature(double temperature) {
        if (!validateTemperature(temperature)) {
            throw new IllegalArgumentException("Invalid temperature");
        }
        this.temperature = temperature;
    }

    public boolean validateTemperature(double temperature) {
        return temperature >= lowestTemperature && temperature <= highestTemperature;
    }
}
