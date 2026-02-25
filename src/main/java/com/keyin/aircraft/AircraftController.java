package com.keyin.aircraft;

import com.keyin.aircraft.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AircraftController {

    @Autowired
    AircraftService aircraftService;

    public Iterable<Aircraft> getAllAircraft(){
        return aircraftService.getAllAircraft();
    }
}
