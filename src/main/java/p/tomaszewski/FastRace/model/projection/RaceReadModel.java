package p.tomaszewski.FastRace.model.projection;

import p.tomaszewski.FastRace.enums.Surface;
import p.tomaszewski.FastRace.model.Race;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class RaceReadModel {
    private int id;
    private String name;
    private String surface;
    private LocalDateTime data;
//    private Set<DriverRaceResultReadModel> driverRaceResults;


    public RaceReadModel(Race source) {
        name = source.getName();
        surface = source.getSurface();
        data = source.getData();
        id = source.getId();

//        driverRaceResults = source.getDriverRaceResults().stream().map(DriverRaceResultReadModel::new)
//                .collect(Collectors
//                        .toSet());

    }

//    public Set<DriverRaceResultReadModel> getDriverRaceResults() {
//        return driverRaceResults;
//    }
//
//    public void setDriverRaceResults(Set<DriverRaceResultReadModel> driverRaceResults) {
//        this.driverRaceResults = driverRaceResults;
//    }


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

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
