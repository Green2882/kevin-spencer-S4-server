package com.keyin.airport;

import com.keyin.city.City;
import com.keyin.city.CityService;
import com.keyin.passenger.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/airports")
@CrossOrigin
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Airport>>getAirportById(@PathVariable Long id){
        return ResponseEntity.ok(airportService.findAirportById(id));
    }

    @GetMapping("/requestparam")
    public ResponseEntity<Optional<Airport>>getByIdRequestParameter(@RequestParam Long id){
        return ResponseEntity.ok(airportService.findAirportById(id));
    }

    @GetMapping()
    public ResponseEntity<Iterable<Airport>> getAllCities(){
        return ResponseEntity.ok(airportService.findAllAirports());
    }

    @PostMapping()
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport){
        return ResponseEntity.ok(airportService.createAirport(airport));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAirportById(@PathVariable Long id){
        airportService.deleteAirportById(id);
        return ResponseEntity.ok("Airport with id " + id + " deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAirport(@PathVariable Long id, @RequestBody Airport airport){
        airportService.updateAirport(id, airport); // saves
        return ResponseEntity.ok("Airport with id " + id + " updated successfully");
    }
}
