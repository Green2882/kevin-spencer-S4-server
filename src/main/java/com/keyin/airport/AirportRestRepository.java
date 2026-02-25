package com.keyin.airport;

import com.keyin.airport.Airport;
import com.keyin.city.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AirportRestRepository extends CrudRepository<Airport, Long> {
    Airport getAirportsByCity(City city);

    Optional<Airport> findAirportByCity(City city);
}
