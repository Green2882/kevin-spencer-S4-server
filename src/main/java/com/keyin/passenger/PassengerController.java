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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePassengerById(@PathVariable Long id){
        passengerService.deletePassengerById(id);
        return ResponseEntity.ok("Passenger with id " + id + " deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePassenger(@PathVariable Long id, @RequestBody Passenger passenger){
        passengerService.updatePassenger(id, passenger); // saves
        return ResponseEntity.ok("Passenger with id " + id + " updated successfully");
    }
}