package com.keyin.passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    private PassengerRestRepository passengerRestRepository;

    public Passenger createPassenger(Passenger city){
        return passengerRestRepository.save(city);
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

}
