package p.tomaszewski.FastRace.model;

import java.util.Set;

public class DriverResult {
    private int driver;
    private String driverName;
    private Set<DriverRaceResult> raceResults;

    public DriverResult() {
    }

    public Set<DriverRaceResult> getRaceResults() {
        return raceResults;
    }

    public void setRaceResults(Set<DriverRaceResult> raceResults) {
        this.raceResults = raceResults;
    }


    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public DriverResult(int driver) {
        this.driver = driver;
    }

    public int getDriver() {
        return driver;
    }

    public void setDriver(int driver) {
        this.driver = driver;
    }
}
