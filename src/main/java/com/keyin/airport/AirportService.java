package com.keyin.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirportService {

    @Autowired
    private AirportRestRepository airportRestRepository;

    public Airport createAirport(Airport airport) {
        return airportRestRepository.save(airport);
    }

    public Iterable<Airport> findAllAirports() {
        return airportRestRepository.findAll();
    }

    public Optional<Airport> findAirportById(Long id) {
        return airportRestRepository.findById(id);
    }

    public void deleteAirportById(Long id) {
        airportRestRepository.deleteById(id);
    }

    public Airport updateAirport(Long id, Airport airport) {
        Optional<Airport> existingAirport = airportRestRepository.findById(id);

        if (existingAirport.isPresent()) {
            Airport airportFromDb = existingAirport.get();

            airportFromDb.setName(airport.getName());
            airportFromDb.setCode(airport.getCode());

            return airportRestRepository.save(airportFromDb);
        } else {
            throw new RuntimeException("Airport not found.");
        }
    }
 }
