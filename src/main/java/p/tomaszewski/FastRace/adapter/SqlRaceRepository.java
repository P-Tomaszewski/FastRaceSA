package p.tomaszewski.FastRace.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import p.tomaszewski.FastRace.model.Race;
import p.tomaszewski.FastRace.model.RaceRepository;

@Repository
interface SqlRaceRepository extends RaceRepository, JpaRepository<Race, Integer> {

}

