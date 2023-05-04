package ru.muctr.Lab8;

import java.util.Date;

public class Task implements Runnable {
    private String name;
    private double speed;
    private long distance;
    private long sleepTime;
    private Date startTime;
    private Date endTime;
    private RelayRace relayRace;

    public Task(String name, double speed, long distance, RelayRace relayRace) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
        this.relayRace = relayRace;
        this.sleepTime = (long) (distance / speed * 500);
    }

    @Override
    public void run() {
        try {
            // Старт потока-атлета
            synchronized (relayRace) {
                relayRace.addRunner();
                if (relayRace.getRunnersCount() == 2) {
                    relayRace.notifyAll();
                    System.out.println(new Date() + ": Эстафета началась");
                } else {
                    relayRace.wait();
                }
            }

            // Спим, чтобы пробежать заданное расстояние
            Thread.sleep(sleepTime);

            // Завершение гонки
            synchronized (relayRace) {
                endTime = new Date();
                System.out.println(name + " из команды " + relayRace.getTeam() + " финишировал в " + endTime);
                relayRace.setWinner(name);
                relayRace.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

