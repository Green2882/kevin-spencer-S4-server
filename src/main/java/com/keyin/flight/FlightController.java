package com.keyin.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/flights")
@CrossOrigin

public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Flight>> getFlightById(@PathVariable Long id) {
        return ResponseEntity.ok(flightService.findFlightById(id));
    }

    @GetMapping("/requestparam")
    public ResponseEntity<Optional<Flight>> getByIdRequestParameter(@RequestParam Long id) {
        return ResponseEntity.ok(flightService.findFlightById(id));
    }

    @GetMapping()
    public ResponseEntity<Iterable<Flight>> getAllFlights() {
        return ResponseEntity.ok(flightService.findAllFlights());
    }

    @PostMapping()
    public ResponseEntity<Flight> createCity(@RequestBody Flight flight) {
        return ResponseEntity.ok(flightService.createFlight(flight));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFlightById(@PathVariable Long id) {
        flightService.deleteFlightById(id);
        return ResponseEntity.ok("Flight with id " + id + " deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
        flightService.updateFlight(id, flight); // saves
        return ResponseEntity.ok("Flight with id " + id + " updated successfully");
    }

}
