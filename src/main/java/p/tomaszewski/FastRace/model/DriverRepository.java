package p.tomaszewski.FastRace.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
//interfejs dla driver, definicje metod
public interface DriverRepository extends CrudRepository<Driver, Integer> {
    List<Driver> findAll();
    Optional<Driver> findById(Integer id);
    Driver save(Driver entity);
    boolean existsById(Integer id);
    void deleteById(int id);


}
