package com.keyin.aircraft;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class AircraftService {

    @Autowired
    private AircraftRestRepository aircraftRestRepository;

    public Aircraft createAircraft(Aircraft aircraft) { return aircraftRestRepository.save(aircraft);}

    public Iterable<Aircraft> findAllAircraft() {return aircraftRestRepository.findAll();}

    public Optional<Aircraft> findAircraftById(Long id) {return aircraftRestRepository.findById(id);}

    public void deleteAircraftById(Long id) {aircraftRestRepository.deleteById(id);}

    public Aircraft updateAircraft(Long id, Aircraft aircraft) {
        Optional<Aircraft> existingAircraft = aircraftRestRepository.findById(id);

        if (existingAircraft.isPresent()) {
            Aircraft aircraftFromDb = existingAircraft.get();

            aircraftFromDb.setType(aircraft.getType());
            aircraftFromDb.setAirlineName(aircraft.getAirlineName());
            aircraftFromDb.setNumOfPassengers(aircraft.getNumOfPassengers());

            return aircraftRestRepository.save(aircraftFromDb);
        } else {
            throw new RuntimeException("Aircraft not found.");
        }
    }
}
