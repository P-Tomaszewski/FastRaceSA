package p.tomaszewski.FastRace.model.projection;

import p.tomaszewski.FastRace.model.Driver;
import p.tomaszewski.FastRace.model.DriverRaceResult;
import p.tomaszewski.FastRace.model.Race;

public class DriverRaceResultWriteModel {
    private int score;
    private Driver driverObject;
    private int driver;
    private Race raceObject;
    private int race;

    public Driver getDriverObject() {
        return driverObject;
    }

    public void setDriverObject(Driver driverObject) {
        this.driverObject = driverObject;
    }

    public int getRace() {
        return race;
    }

    public void setRace(int raceId) {
        this.race = raceId;
    }

    public int getDriver() {
        return driver;
    }

    public void setDriver(int driver) {
        this.driver = driver;
    }

    public Race getRaceObject() {
        return raceObject;
    }

    public void setRaceObject(Race raceObject) {
        this.raceObject = raceObject;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

//    public DriverRaceResult toDriverRaceResult(){
//        return new DriverRaceResult();
//    }

    public DriverRaceResult toDriverRaceResult(){
        var result = new DriverRaceResult();
        result.setDriver(driverObject);
        result.setRace(raceObject);
        result.setScore(score);
        return result;
    }
}
