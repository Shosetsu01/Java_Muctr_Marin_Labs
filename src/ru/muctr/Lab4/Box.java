package ru.muctr.Lab4;

public class Box<T extends Fruit> {
    private T fruit;
    private int number;

    public Box(T fruit, int number) {
        this.fruit = fruit;
        this.number = number;
    }

    public double getTotalWeight() {
        return fruit.getWeight() * number;
    }

    public void transferFruits(Box<T> destBox) {
//        if (this.fruit.getClass() != destBox.fruit.getClass()) {
//            throw new IllegalArgumentException("Коробки должны содержать фрукты одинаковых типов");
//        }
        destBox.number += this.number;
        this.number = 0;
    }
}



