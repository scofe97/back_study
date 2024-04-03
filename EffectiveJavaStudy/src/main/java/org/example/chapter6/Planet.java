package org.example.chapter6;

public enum Planet {
    MERCURY(3.302e+23, 2.439e6),
    VENUS(4.869, 6.052),
    EARTH(4.896, 6.05),
    MARS(6.419, 3.319);


    private final double mass;
    private final double radius;
    private final double surfaceGravity;

    private static final double G = 6.67;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        this.surfaceGravity = G * mass / (radius * radius);
    }

    public double mass() { return mass; }
    public double radius() { return radius; }
    public double surfaceGravity() { return surfaceGravity; }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity;
    }
}