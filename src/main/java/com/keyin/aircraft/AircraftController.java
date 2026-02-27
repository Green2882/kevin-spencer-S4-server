package com.keyin.aircraft;

import com.keyin.airport.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/aircraft")
@CrossOrigin
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aircraft>> getAircraftById(@PathVariable Long id){
        return ResponseEntity.ok(aircraftService.findAircraftById(id));
    }

    @GetMapping("/requestparam")
    public ResponseEntity<Optional<Aircraft>>getByIdRequestParameter(@RequestParam Long id){
        return ResponseEntity.ok(aircraftService.findAircraftById(id));
    }

    @GetMapping()
    public ResponseEntity<Iterable<Aircraft>> getAllAircraft(){
        return ResponseEntity.ok(aircraftService.findAllAircraft());
    }

    @PostMapping()
    public ResponseEntity<Aircraft> createAircraft(@RequestBody Aircraft aircraft){
        return ResponseEntity.ok(aircraftService.createAircraft(aircraft));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAircraftById(@PathVariable Long id){
        aircraftService.deleteAircraftById(id);
        return ResponseEntity.ok("Aircraft with id " + id + " deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAircraft(@PathVariable Long id, @RequestBody Aircraft aircraft){
        aircraftService.updateAircraft(id, aircraft); // saves
        return ResponseEntity.ok("Aircraft with id " + id + " updated successfully");
    }
}