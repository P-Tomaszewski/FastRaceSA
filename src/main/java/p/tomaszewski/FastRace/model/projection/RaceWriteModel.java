package p.tomaszewski.FastRace.model.projection;

import org.springframework.format.annotation.DateTimeFormat;
import p.tomaszewski.FastRace.enums.Surface;
import p.tomaszewski.FastRace.model.Race;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RaceWriteModel {
    @NotEmpty
    private String name;
    private Surface surface;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @NotNull
    private LocalDateTime data;
    private List<DriverRaceResultWriteModel> driverRaceResults = new ArrayList<>();

    public RaceWriteModel() {
        driverRaceResults.add(new DriverRaceResultWriteModel());
    }

    public List<DriverRaceResultWriteModel> getDriverRaceResults() {
        return driverRaceResults;
    }

    public void setDriverRaceResults(List<DriverRaceResultWriteModel> driverRaceResults) {
        this.driverRaceResults = driverRaceResults;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurface() {
        return surface.getDisplayValue();
    }

    public void setSurface(Surface surface) {
        this.surface = surface;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Race toRace(){
        Race result = new Race();
        result.setName(name);
        result.setSurface(surface);
        result.setData(data);
//        result.setDriverRaceResults(
//                driverRaceResults.stream()
//                        .map(DriverRaceResultWriteModel::toDriverRaceResult)
//                        .collect(Collectors.toSet()));
        return result;
    }
}
