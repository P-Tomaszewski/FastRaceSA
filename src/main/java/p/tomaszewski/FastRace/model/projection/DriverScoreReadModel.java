package p.tomaszewski.FastRace.model.projection;

import p.tomaszewski.FastRace.model.DriverRaceResult;

public class DriverScoreReadModel {
    private String firstName;
    private String lastName;
    private String team;
    private String car;
    private Integer score;

    public DriverScoreReadModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }



}
