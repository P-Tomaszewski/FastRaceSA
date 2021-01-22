package p.tomaszewski.FastRace.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import p.tomaszewski.FastRace.enums.Surface;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "races")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String surface;
    @NotNull
    private LocalDateTime data;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "race", orphanRemoval = true)
    private Set<DriverRaceResult> driverRaceResults;

    public Race() {
    }

    public Set<DriverRaceResult> getDriverRaceResults() {
        return driverRaceResults;
    }

    public void setDriverRaceResults(Set<DriverRaceResult> driverRaceResults) {
        this.driverRaceResults = driverRaceResults;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(Surface surface) {
        this.surface = surface.getDisplayValue();
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
