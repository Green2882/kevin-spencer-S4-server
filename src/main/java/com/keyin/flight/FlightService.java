package com.keyin.flight;

import com.keyin.gate.Gate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRestRepository flightRestRepository;

    public Flight createFlight(Flight flight){
        return flightRestRepository.save(flight);
    }

    public Iterable<Flight> findAllFlights(){
        return flightRestRepository.findAll();
    }

    public Optional<Flight> findFlightById(Long id){
        return flightRestRepository.findById(id);
    }

    public Iterable<Flight> findByGate(Gate gate) {
        return flightRestRepository.findByGate(gate);
    }

    public void deleteFlightById(Long id){
        if (flightRestRepository.existsById(id)) {
            flightRestRepository.deleteById(id);
        } else {
            throw new RuntimeException("Flight not found with id: " + id);
        }
    }

    public Flight updateFlight(Long id, Flight flight) {
        Optional<Flight> existingFlight = flightRestRepository.findById(id);

        if (existingFlight.isPresent()) {
            Flight flightFromDb = existingFlight.get();

            flightFromDb.setFlightNumber(flight.getFlightNumber());
            flightFromDb.setDepartureTime(flight.getDepartureTime());
            flightFromDb.setArrivalTime(flight.getArrivalTime());
            flightFromDb.setAircraft(flight.getAircraft());
            flightFromDb.setOriginAirport(flight.getOriginAirport());
            flightFromDb.setDestinationAirport(flight.getDestinationAirport());
            flightFromDb.setGate(flight.getGate());
            flightFromDb.setPassengers(flight.getPassengers());

            return flightRestRepository.save(flightFromDb);
        } else {
            throw new RuntimeException("Flight not found with id: " + id);
        }
    }
}
