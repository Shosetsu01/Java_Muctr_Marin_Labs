package ru.muctr.Lab8;

import java.util.Date;

public class Task implements Runnable {
    private String athleteName;
    private String teamName;
    private int distance;
    private int speed;
    private Task nextRunner;
    private long startTime;
    private long finishTime;

    public Task(String athleteName, String teamName, int distance, int speed) {
        this.athleteName = athleteName;
        this.teamName = teamName;
        this.distance = distance;
        this.speed = speed;
    }

    public void setNextRunner(Task nextRunner) {
        this.nextRunner = nextRunner;
    }

    public String getTeamName() {
        return teamName;
    }

    public long getFinishTime() {
        return finishTime;
    }

    @Override
    public void run() {
        System.out.println("\uD83C\uDFC3 " + athleteName + " из " + teamName + " побежал со скоростью " + speed +  "м/с время старта "+  new Date());

        startTime = System.currentTimeMillis();
        int remainingDistance = distance;

        while (remainingDistance > 0) {
            // Вычисляем время, которое поток должен спать, чтобы передвинуться на 1 метр
            long sleepTime = (long) ((double) 1000 / speed);

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            remainingDistance--;
        }

        finishTime = System.currentTimeMillis();
        System.out.println("\uD83C\uDF89 " + athleteName + " из " + teamName + " финишировал в " + new Date());

        if (nextRunner != null) {
            System.out.println("\uD83D\uDCE6 " + athleteName + " передал эстафету напарнику из " + nextRunner.getTeamName() + ".");
            nextRunner.run();
        }
    }
}
