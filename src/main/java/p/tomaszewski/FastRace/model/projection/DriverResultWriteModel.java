package p.tomaszewski.FastRace.model.projection;

import p.tomaszewski.FastRace.model.Driver;
import p.tomaszewski.FastRace.model.DriverRaceResult;
import p.tomaszewski.FastRace.model.DriverResult;
import p.tomaszewski.FastRace.model.Race;

public class DriverResultWriteModel {
    private int driver;

    public int driver() {
        return driver;
    }

    public void setDriver(int driver) {
        driver = driver;
    }

    public DriverResult toResult(){
        var result = new DriverResult();
        result.setDriver(driver);
        return result;
    }

}
