package com.keyin.passenger;

import com.keyin.airport.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class PassengerService {

    @Autowired
    private PassengerRestRepository passengerRestRepository;

    public Passenger createPassenger(Passenger passenger){
        return passengerRestRepository.save(passenger);
    }

    public Iterable<Passenger> findAllPassengers(){
        return passengerRestRepository.findAll();
    }

    public Optional<Passenger> findPassengerById(Long id){
        return passengerRestRepository.findById(id);
    }

    public void deletePassengerById(Long id){
        passengerRestRepository.deleteById(id);
    }

    public Passenger updatePassenger(Long id, Passenger passenger) {

        Optional<Passenger> existingPassenger = passengerRestRepository.findById(id);

        if (existingPassenger.isPresent()) {
            Passenger passengerFromDb = existingPassenger.get();

            passengerFromDb.setFirstName(passenger.getFirstName());
            passengerFromDb.setLastName(passenger.getLastName());
            passengerFromDb.setPhoneNum(passenger.getPhoneNum());
            passengerFromDb.setCity(passenger.getCity());

            return passengerRestRepository.save(passengerFromDb);

        } else {
            throw new RuntimeException("Passenger not found");
        }
    }

    public Iterable<Map<String, Object>> getAirportsUsedByPassengers() {
        Iterable<Passenger> passengers = findAllPassengers();

        List<Map<String, Object>> results = new ArrayList<>();

        for (Passenger passenger : passengers) {
            Set<Airport> airportsUsed = new HashSet<>();

            if (passenger.getAircraft() != null) {
                passenger.getAircraft().forEach(aircraft -> {
                    if (aircraft.getAirports() != null) {
                        airportsUsed.addAll(aircraft.getAirports());
                    }
                });
            }

            Map<String, Object> row = new HashMap<>();
            row.put("passenger", passenger);
            row.put("airports", airportsUsed);

            results.add(row);
        }

        return results;
    }
}