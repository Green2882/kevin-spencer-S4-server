package com.keyin.aircraft;

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

    @DeleteMapping()
    public ResponseEntity<String> deleteAircraftById(@RequestParam Long id){
        aircraftService.deleteAircraftById(id);
        return ResponseEntity.ok("Aircraft with id " + id + " deleted successfully");
    }

    @PutMapping("")
    public ResponseEntity<String> put(@RequestParam Long id, @RequestBody Aircraft aircraft){

        Optional<Aircraft> aircraftOptional = aircraftService.findAircraftById(id);

        aircraftOptional.get().setType(aircraft.getType());
        aircraftOptional.get().setAirlineName(aircraft.getAirlineName());
        aircraftOptional.get().setAirlineName(aircraft.getAirlineName());

        return ResponseEntity.ok("Aircraft with id " + id + " updated successfully");
    }


}