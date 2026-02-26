package com.keyin.aircraft;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class AircraftService {

    @Autowired
    private AircraftRestRepository aircraftRestRepository;

    public Iterable<Aircraft> getAllAircraft() {
        return aircraftRestRepository.findAll();
    }

    public Aircraft saveAircraft(Aircraft aircraft) {
        return aircraftRestRepository.save(aircraft);
    }

    public Optional<Aircraft> getAircraftById(Long id) {
        return aircraftRestRepository.findById(id);
    }

    public Optional<Aircraft> getAircraftByType(String type) {
        return aircraftRestRepository.getAircraftByType(type);
    }
}
