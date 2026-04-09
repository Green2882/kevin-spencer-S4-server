package com.keyin.airline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
            Airline airlineFromDb = existingAirline.get();

            airlineFromDb.setName(airline.getName());

            return airlineRestRepository.save(airlineFromDb);
        } else {
            throw new RuntimeException("Airline not found.");
        }
    }


}
