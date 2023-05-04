package ru.muctr.Lab4;

public class Apple extends Fruit {
    private double weight;

    public Apple(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return "Apple";
    }

    public double getWeight() {
        return weight;
    }
}
