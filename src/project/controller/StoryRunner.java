package project.controller;

import project.bulding.LocationException;
import project.database.Database;
import project.middleware.Strategy;
import project.middleware.*;
import project.time.BasicTimer;
import project.time.Season;
import project.time.Timer;

public class StoryRunner {
    private Timer timer;
    private Database database;
    private Strategy strategy;

    public StoryRunner() {
        timer = new BasicTimer();
        database = new Database();
    }

    public StoryRunner(String parameter) {
        database = new Database();
        if (parameter.equals("random")) setRandomTimer();
    }

    private void process() {
        if (timer.getSeason() == Season.WINTER) {
            setStrategy(new WinterStrategy());
        }
        else if (timer.getSeason() == Season.SPRING) {
            setStrategy(new SpringStrategy());
        }
        else if (timer.getSeason() == Season.SUMMER) {
            setStrategy(new SummerStrategy());
        }
        else {
            setStrategy(new AutumnStrategy());
        }
        useCurrentStrategy();
        timer.process();
    }

    public void run(int seasons){
        for (int i = 0; i < seasons; i++) {
            this.process();
        }
        System.out.println("И вот конец истории.");
    }

    private void setRandomTimer() {
        timer = new BasicTimer("random");
    }

    private void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    private void useCurrentStrategy() {
        strategy.execute(database.getCharacters());
    }
}
