package com.keyin.aircraft;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AircraftRestRepository extends CrudRepository<Aircraft, Long> {
    Optional<Aircraft> getAircraftByType(String type);

    Optional<Aircraft> findAircraftByType(String type);

    Optional<Aircraft> findAircraftByAirlineName(String airlineName);

    Optional<Aircraft> findAircraftByNumOfPassengers(String numOfPassengers);
}