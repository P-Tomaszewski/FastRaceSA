package p.tomaszewski.FastRace.model.projection;

import p.tomaszewski.FastRace.model.Driver;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class DriverWriteModel {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String team;
    @NotEmpty
    private String car;
    private LocalDateTime overview;
    private Set<DriverRaceResultWriteModel> driverRaceResults;

    public Set<DriverRaceResultWriteModel> getDriverRaceResults() {
        return driverRaceResults;
    }

    public void setDriverRaceResults(Set<DriverRaceResultWriteModel> driverRaceResults) {
        this.driverRaceResults = driverRaceResults;
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

    public LocalDateTime getOverview() {
        return overview;
    }

    public void setOverview(LocalDateTime overview) {
        this.overview = overview;
    }

    public Driver toDriver(){
        var result = new Driver();
        result.setCar(car);
        result.setFirstName(firstName);
        result.setLastName(lastName);
        result.setTeam(team);
//        result.setDriverRaceResults(
//                driverRaceResults.stream()
//                        .map(DriverRaceResultWriteModel::toDriverRaceResult)
//                        .collect(Collectors.toSet()));
    return result;
    }
}
