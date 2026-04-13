package com.keyin.gate;

import com.keyin.airport.Airport;
import com.keyin.airport.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gates")
@CrossOrigin
public class GateController {

    @Autowired
    private GateService gateService;

    @Autowired
    private AirportService airportService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getGateById(@PathVariable Long id) {
        Optional<Gate> gate = gateService.findGateById(id);
        if (gate.isPresent()) {
            return ResponseEntity.ok(gate.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping()
    public ResponseEntity<Iterable<Gate>> getAllGates() {
        return ResponseEntity.ok(gateService.findAllGates());
    }

    @GetMapping("/airport/{airportId}")
    public ResponseEntity<?> getGatesByAirport(@PathVariable Long airportId) {
        Optional<Airport> airport = airportService.findAirportById(airportId);
        if (airport.isPresent()) {
            List<Gate> gates = gateService.findByAirport(airport.get());
            if (gates.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(gates);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/gateNumber/{gateNumber}")
    public ResponseEntity<?> getGatesByGateNumber(@PathVariable String gateNumber) {
        List<Gate> gates = gateService.findByGateNumber(gateNumber);
        if (gates.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(gates);
    }

    @PostMapping()
    public ResponseEntity<Gate> createGate(@RequestBody Gate gate) {
        return ResponseEntity.ok(gateService.createGate(gate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGateById(@PathVariable Long id) {
        try {
            gateService.deleteGateById(id);
            return ResponseEntity.ok("Gate with id " + id + " deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGate(@PathVariable Long id, @RequestBody Gate gate) {
        try {
            gateService.updateGate(id, gate);
            return ResponseEntity.ok("Gate with id " + id + " updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
