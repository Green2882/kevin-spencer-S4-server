package com.keyin.flight;

import com.keyin.gate.Gate;
import com.keyin.gate.GateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
@CrossOrigin
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private GateService gateService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getFlightById(@PathVariable Long id) {
        Optional<Flight> flight = flightService.findFlightById(id);
        if (flight.isPresent()) {
            return ResponseEntity.ok(flight.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/requestparam")
    public ResponseEntity<?> getByIdRequestParameter(@RequestParam Long id) {
        Optional<Flight> flight = flightService.findFlightById(id);
        if (flight.isPresent()) {
            return ResponseEntity.ok(flight.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping()
    public ResponseEntity<Iterable<Flight>> getAllFlights() {
        return ResponseEntity.ok(flightService.findAllFlights());
    }

    @GetMapping("/gate/{gateId}")
    public ResponseEntity<?> getFlightsByGate(@PathVariable Long gateId) {
        Optional<Gate> gate = gateService.findGateById(gateId);
        if (gate.isPresent()) {
            Iterable<Flight> flights = flightService.findByGate(gate.get());
            if (flights instanceof Collection && ((Collection<?>) flights).isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(flights);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        return ResponseEntity.ok(flightService.createFlight(flight));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFlightById(@PathVariable Long id) {
        try {
            flightService.deleteFlightById(id);
            return ResponseEntity.ok("Flight with id " + id + " deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
        try {
            flightService.updateFlight(id, flight);
            return ResponseEntity.ok("Flight with id " + id + " updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
