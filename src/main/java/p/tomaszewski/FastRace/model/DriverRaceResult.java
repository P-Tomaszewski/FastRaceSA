package p.tomaszewski.FastRace.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "driverraceresults")
public class DriverRaceResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int score;
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
    @ManyToOne
    @JoinColumn(name = "race_id")
    private Race race;

    public DriverRaceResult() {
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int place) {
        this.score = place;
    }
}