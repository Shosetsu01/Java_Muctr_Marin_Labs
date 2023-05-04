package ru.muctr.Lab4;

public class Persimmon extends Fruit {
    private double weight;

    public Persimmon(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return "Persimmon";
    }

    public double getWeight() {
        return weight;
    }
}
