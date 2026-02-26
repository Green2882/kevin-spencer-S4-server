package com.keyin.airport;

import com.keyin.city.City;
import com.keyin.city.CityService;
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

    @DeleteMapping()
    public ResponseEntity<String> deleteAirportById(@RequestParam Long id){
        airportService.deleteAirportById(id);
        return ResponseEntity.ok("Airport with id " + id + " deleted successfully");
    }

    @PutMapping("")
    public ResponseEntity<String> put(@RequestParam Long id, @RequestBody Airport  airport){
        Optional<Airport> airportOptional = airportService.findAirportById(id);
        airportOptional.get().setName(airport.getName());
        airportOptional.get().setCode(airport.getCode());
        airportOptional.get().setCity(airport.getCity());
        return ResponseEntity.ok("Airport with id " + id + " updated successfully");
    }
}
