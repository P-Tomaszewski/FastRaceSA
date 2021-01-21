package p.tomaszewski.FastRace.logic;

import org.springframework.stereotype.Service;
import p.tomaszewski.FastRace.model.DriverRaceResult;
import p.tomaszewski.FastRace.model.DriverRaceResultRepository;
import p.tomaszewski.FastRace.model.Race;
import p.tomaszewski.FastRace.model.projection.DriverRaceResultReadModel;
import p.tomaszewski.FastRace.model.projection.DriverRaceResultWriteModel;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverRaceResultService {
    private DriverRaceResultRepository repository;

    public DriverRaceResultService(DriverRaceResultRepository repository) {
        this.repository = repository;
    }

    public DriverRaceResultReadModel createDriverRaceResultService(DriverRaceResultWriteModel source) {
        DriverRaceResult result = repository.save(source.toDriverRaceResult());
        return new DriverRaceResultReadModel(result);
    }

    public List<DriverRaceResultReadModel> readAll(){
        return repository.findAll().stream()
                .map(DriverRaceResultReadModel::new)
                .collect(Collectors.toList());
    }
}
