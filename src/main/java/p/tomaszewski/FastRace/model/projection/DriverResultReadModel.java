package p.tomaszewski.FastRace.model.projection;

import p.tomaszewski.FastRace.model.Driver;
import p.tomaszewski.FastRace.model.Race;

public class DriverResultReadModel {
    private int driverId;
    private String raceName;
    private int Score;

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }
}
