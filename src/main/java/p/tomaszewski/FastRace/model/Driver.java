package p.tomaszewski.FastRace.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @NotEmpty(message = "imie nie moze byc puste")
    public String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String team;
    @NotEmpty
    private String car;
    private LocalDateTime overview;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driver", orphanRemoval = true)
    private List<DriverRaceResult> driverRaceResults;

    public Driver() {
    }

    public List<DriverRaceResult> getDriverRaceResults() {
        return driverRaceResults;
    }

    public void setDriverRaceResults(List<DriverRaceResult> driverRaceResults) {
        this.driverRaceResults = driverRaceResults;
    }

    public LocalDateTime getOverview() {
        return overview;
    }

    public Driver(@NotNull String firstName, String lastName, String team,
                  String car, LocalDateTime overview) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
        this.car = car;
    }

    public void setOverview(LocalDateTime overview) {
        this.overview = overview;
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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
