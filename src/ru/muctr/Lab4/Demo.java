package ru.muctr.Lab4;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Apple apple = new Apple(0.2);
        Persimmon persimmon = new Persimmon(0.3);
        Box<Apple> appleBox1 = new Box<>(apple, 10);
        Box<Persimmon> persimmonBox1 = new Box<>(persimmon, 5);
        Box<Apple> appleBox2 = new Box<>(apple, 8);
        Box<Persimmon> persimmonBox2 = new Box<>(persimmon, 3);
        Box<Apple> appleBox3 = new Box<>(apple, 6);
        Box<Persimmon> persimmonBox3 = new Box<>(persimmon, 2);
        Box<Apple> appleBox4 = new Box<>(apple, 4);
        Box<Persimmon> persimmonBox4 = new Box<>(persimmon, 1);

//        appleBox4.transferFruits(persimmonBox2);

        Box<?>[] boxes = {
                appleBox1, persimmonBox1,
                appleBox2, persimmonBox2,
                appleBox3, persimmonBox3,
                appleBox4, persimmonBox4
        };

        double totalWeight = calculateTotalWeight(boxes);
        System.out.println("Суммапный вес всез коробок: " + totalWeight + " кг");
    }

    public static double calculateTotalWeight(Box<?>[] boxes) {
        double totalWeight = 0;
        for (Box<?> box : boxes) {
            totalWeight += box.getTotalWeight();
        }
        return totalWeight;
    }
}

