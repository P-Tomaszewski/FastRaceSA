package p.tomaszewski.FastRace.model;

import java.util.List;
import java.util.Optional;
//interfejs dla driver, definicje metod
public interface RaceRepository {
    List<Race> findAll();
    Optional<Race> findById(Integer id);
    Race save(Race entity);
    boolean existsById(Integer id);

}
