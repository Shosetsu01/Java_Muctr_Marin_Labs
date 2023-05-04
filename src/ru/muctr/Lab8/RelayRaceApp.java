package ru.muctr.Lab8;

public class RelayRaceApp {
    public static void main(String[] args) {
        RelayRace relayRace = new RelayRace();

        Task runner1 = new Task("Атлет 1 из команды 1", 5.0, 200, relayRace);
        Task runner2 = new Task("Атлет 2 из команды 1", 6.0, 200, relayRace);
        Task runner3 = new Task("Атлет 1 из команды 2", 4.5, 200, relayRace);
        Task runner4 = new Task("Атлет 2 из команды 2", 5.5, 200, relayRace);

        Thread thread1 = new Thread(runner1);
        Thread thread2 = new Thread(runner2);
        Thread thread3 = new Thread(runner3);
        Thread thread4 = new Thread(runner4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Победитель: " + relayRace.getWinner());
    }
}

