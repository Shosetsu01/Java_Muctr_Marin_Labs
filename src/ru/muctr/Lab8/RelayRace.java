package ru.muctr.Lab8;

public class RelayRace {
    private String team1 = "Команда 1";
    private String team2 = "Команда 2";
    private String winner;
    private int runnersCount = 0;

    public synchronized void addRunner() {
        runnersCount++;
    }

    public synchronized int getRunnersCount() {
        return runnersCount;
    }

    public synchronized String getTeam() {
        if (runnersCount % 2 == 0) {
            return team2;
        } else {
            return team1;
        }
    }

    public synchronized void setWinner(String name) {
        if (winner == null) {
            winner = name;
        }
    }

    public synchronized String getWinner() {
        return winner;
    }
}

