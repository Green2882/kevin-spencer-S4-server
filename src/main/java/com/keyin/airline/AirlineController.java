package com.keyin.airline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/airline")
@CrossOrigin
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Airline>> getAirlineById(@PathVariable Long id){
        return ResponseEntity.ok(airlineService.findAirlineById(id));
    }

    @GetMapping("/requestparam")
    public ResponseEntity<Optional<Airline>> getByIdRequestParameter(@RequestParam Long id){
        return ResponseEntity.ok(airlineService.findAirlineById(id));
    }

    @GetMapping()
    public ResponseEntity<Iterable<Airline>> getAllAirlines(){
        return ResponseEntity.ok(airlineService.findAllAirlines());
    }

    @PostMapping()
    public ResponseEntity<Airline> createAirline(@RequestBody Airline airline){
        return ResponseEntity.ok(airlineService.createAirline(airline));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAirlineById(@PathVariable Long id){
        airlineService.deleteAirlineById(id);
        return ResponseEntity.ok("Airline with id " + id + " deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAirline(@PathVariable Long id, @RequestBody Airline airline){
        airlineService.updateAirline(id, airline);
        return ResponseEntity.ok("Airline with id " + id + " updated successfully");
    }
}
