package com.keyin.passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/passengers")
@CrossOrigin
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Passenger>>getPassengerById(@PathVariable Long id){
        return ResponseEntity.ok(passengerService.findPassengerById(id));
    }

    @GetMapping("/requestparam")
    public ResponseEntity<Optional<Passenger>>getPassengerByIdRequestParameter(@RequestParam Long id){
        return ResponseEntity.ok(passengerService.findPassengerById(id));
    }

    @GetMapping()
    public ResponseEntity<Iterable<Passenger>> getAllPassengers(){
        return ResponseEntity.ok(passengerService.findAllPassengers());
    }


    @PostMapping
    public ResponseEntity<Passenger> createPassenger(@RequestBody Passenger passenger){
        return ResponseEntity.ok(passengerService.createPassenger(passenger));
    }

    @DeleteMapping
    public ResponseEntity<String> deletePassengerById(@RequestParam Long id){
        passengerService.deletePassengerById(id);
        return ResponseEntity.ok("Passenger with id " + id + " deleted successfully");
    }

    @PutMapping
    public ResponseEntity<String> put(@RequestParam Long id, @RequestBody Passenger passenger){
        Optional<Passenger> passengerOptional = passengerService.findPassengerById(id);
        passengerOptional.get().setFirstName(passenger.getFirstName());
        passengerOptional.get().setLastName(passenger.getLastName());
        passengerOptional.get().setPhoneNum(passenger.getPhoneNum());
        passengerOptional.get().setCity(passenger.getCity());
        return ResponseEntity.ok("Passenger with id " + id + " updated successfully");
    }


}