package p.tomaszewski.FastRace.logic;

import org.springframework.stereotype.Service;
import p.tomaszewski.FastRace.model.Race;
import p.tomaszewski.FastRace.model.RaceRepository;
import p.tomaszewski.FastRace.model.projection.RaceReadModel;
import p.tomaszewski.FastRace.model.projection.RaceWriteModel;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RaceService {
    private RaceRepository repository;

    public RaceService(RaceRepository repository) {
        this.repository = repository;
    }

    public RaceReadModel createRace(RaceWriteModel source){
        Race result =  repository.save(source.toRace());
        return new RaceReadModel(result);
    }

    public List<RaceReadModel> readAll(){
        return repository.findAll().stream()
                .map(RaceReadModel::new)
                .collect(Collectors.toList());
    }

    public Optional<Race> findById(int id){
        return repository.findById(id);
    }
}