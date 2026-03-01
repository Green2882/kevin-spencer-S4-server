package com.keyin.aircraft;

import com.keyin.airport.Airport;
import com.keyin.airport.AirportRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AircraftService {

    @Autowired
    private AircraftRestRepository aircraftRestRepository;

    @Autowired
    private AirportRestRepository airportRestRepository;

    public Aircraft createAircraft(Aircraft aircraft) {
        return aircraftRestRepository.save(aircraft);
    }

    public Iterable<Aircraft> findAllAircraft() {
        return aircraftRestRepository.findAll();
    }

    public Optional<Aircraft> findAircraftById(Long id) {
        return aircraftRestRepository.findById(id);
    }

    public void deleteAircraftById(Long id) {
        aircraftRestRepository.deleteById(id);
    }

    public Aircraft updateAircraft(Long id, Aircraft aircraft) {
        Optional<Aircraft> existingAircraft = aircraftRestRepository.findById(id);

        if (existingAircraft.isPresent()) {
            Aircraft aircraftFromDb = existingAircraft.get();

            aircraftFromDb.setType(aircraft.getType());
            aircraftFromDb.setAirlineName(aircraft.getAirlineName());
            aircraftFromDb.setNumOfPassengers(aircraft.getNumOfPassengers());

            return aircraftRestRepository.save(aircraftFromDb);
        } else {
            throw new RuntimeException("Aircraft not found.");
        }
    }

    public Aircraft updateAircraftAirports(Long aircraftId, Iterable<Long> airportIds) {
        Optional<Aircraft> existingAircraft = aircraftRestRepository.findById(aircraftId);

        if (existingAircraft.isEmpty()) {
            throw new RuntimeException("Aircraft not found.");
        }

        Aircraft aircraftFromDb = existingAircraft.get();

        Set<Airport> airports = new HashSet<>();
        for (Long airportId : airportIds) {
            Optional<Airport> airport = airportRestRepository.findById(airportId);
            if (airport.isEmpty()) {
                throw new RuntimeException("Airport not found: " + airportId);
            }
            airports.add(airport.get());
        }

        aircraftFromDb.setAirports(airports);
        return aircraftRestRepository.save(aircraftFromDb);
    }
}