package p.tomaszewski.FastRace.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import p.tomaszewski.FastRace.model.DriverRaceResult;
import p.tomaszewski.FastRace.model.DriverRaceResultRepository;


@Repository
interface SqlDriverRaceResultRepository extends DriverRaceResultRepository, JpaRepository<DriverRaceResult, Integer> {
    @Override
    @Query(nativeQuery = true, value = "select count(*) > 0 from driverraceresults where DRIVER_ID=?2 AND RACE_ID = ?1")
    boolean checkValueExists(int idRace, int idDriver);
}