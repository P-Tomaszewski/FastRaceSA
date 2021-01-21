package p.tomaszewski.FastRace.model.projection;

import p.tomaszewski.FastRace.model.DriverRaceResult;

public class DriverRaceResultReadModel {
    private int score;
    private int driver;
    private int race;


    public DriverRaceResultReadModel(DriverRaceResult source) {
        score = source.getScore();
        driver = source.getDriver().getId();
        race = source.getRace().getId();
    }

    public int getDriver() {
        return driver;
    }

    public void setDriver(int driver) {
        this.driver = driver;
    }

    public int getRace() {
        return race;
    }

    public void setRace(int race) {
        this.race = race;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}