package ru.muctr.Lab8;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class RelayRace {
    public static void main(String[] args) {
        // генерация случайной скорости от 7 до 12 м/с
        Task firstRunnerTeam1 = new Task("Атлет 1", "Команда 1", 100, new Random().nextInt(6) + 7);
        Task secondRunnerTeam1 = new Task("Атлет 2", "Команда 1", 100, new Random().nextInt(6) + 7);

        Task firstRunnerTeam2 = new Task("Атлет 1", "Команда 2", 100, new Random().nextInt(6) + 7);
        Task secondRunnerTeam2 = new Task("Атлет 2", "Команда 2", 100, new Random().nextInt(6) + 7);

        firstRunnerTeam1.setNextRunner(secondRunnerTeam1);
        firstRunnerTeam2.setNextRunner(secondRunnerTeam2);

        CyclicBarrier barrier = new CyclicBarrier(2);

        Thread thread1 = new Thread(() -> {
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            firstRunnerTeam1.run();
        });

        Thread thread2 = new Thread(() -> {
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            firstRunnerTeam2.run();
        });

        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Эстафета началась! Текущее время: " + new Date());
        System.out.println("-----------------------------------------------------------------------------------");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long team1FinishTime = secondRunnerTeam1.getFinishTime();
        long team2FinishTime = secondRunnerTeam2.getFinishTime();
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("\uD83C\uDFC1 " + "Команда 1 финишировала в " + new Date(team1FinishTime));
        System.out.println("\uD83C\uDFC1 " + "Команда 2 финишировала в " + new Date(team2FinishTime));
        System.out.println("-----------------------------------------------------------------------------------");
        if (team1FinishTime < team2FinishTime) {
            System.out.println("\uD83C\uDF86\uD83C\uDF86\uD83C\uDF86 " + "Команда 1 победила!");
        } else if (team1FinishTime > team2FinishTime) {
            System.out.println("\uD83C\uDF86\uD83C\uDF86\uD83C\uDF86 " + "Команда 2 победила!");
        } else {
            System.out.println("Это ничья!");
        }
    }
}
