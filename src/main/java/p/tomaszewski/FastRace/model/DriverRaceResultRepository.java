package p.tomaszewski.FastRace.model;

import java.util.List;
import java.util.Optional;

//interfejs dla driver, definicje metod
public interface DriverRaceResultRepository {
    List<DriverRaceResult> findAll();

    Optional<DriverRaceResult> findById(Integer id);

    DriverRaceResult save(DriverRaceResult entity);

    boolean existsById(Integer id);

    boolean checkValueExists(int idRace, int idDriver);

}

