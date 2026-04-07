package com.keyin.Airline;

import com.keyin.airport.Airport;
import com.keyin.airport.AirportRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AirlineService {

    @Autowired
    private AirlineRestRepository airlineRestRepository;

    public Airline createAirline(Airline airline) {
        return airlineRestRepository.save(airline);
    }

    public Iterable<Airline> findAllAirlines() {
        return airlineRestRepository.findAll();
    }

    public Optional<Airline> findAirlineById(Long id) {
        return airlineRestRepository.findById(id);
    }

    public void deleteAirlineById(Long id) {
        airlineRestRepository.deleteById(id);
    }

    public Airline updateAirline(Long id, Airline airline) {
        Optional<Airline> existingAirline = airlineRestRepository.findById(id);

        if (existingAirline.isPresent()) {
            Airline AirlineFromDb = existingAirline.get();

            airlineFromDb.setType(airline.getType());
            airlineFromDb.setAirlineName(airline.getAirlineName());
            airlineFromDb.setNumOfPassengers(airline.getNumOfPassengers());

            return airlineRestRepository.save(airlineFromDb);
        } else {
            throw new RuntimeException("Airline not found.");
        }
    }


}
