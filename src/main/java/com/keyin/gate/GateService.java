package com.keyin.gate;

import com.keyin.airport.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GateService {

    @Autowired
    private GateRestRepository gateRestRepository;

    public Gate createGate(Gate gate) {
        return gateRestRepository.save(gate);
    }

    public Iterable<Gate> findAllGates() {
        return gateRestRepository.findAll();
    }

    public Optional<Gate> findGateById(Long id) {
        return gateRestRepository.findById(id);
    }

    public List<Gate> findByAirport(Airport airport) {
        return gateRestRepository.findByAirport(airport);
    }

    public List<Gate> findByGateNumber(String gateNumber) {
        return gateRestRepository.findByGateNumber(gateNumber);
    }

    public void deleteGateById(Long id) {
        if (gateRestRepository.existsById(id)) {
            gateRestRepository.deleteById(id);
        } else {
            throw new RuntimeException("Gate not found with id: " + id);
        }
    }

    public Gate updateGate(Long id, Gate gate) {
        Optional<Gate> existingGate = gateRestRepository.findById(id);

        if (existingGate.isPresent()) {
            Gate gateFromDb = existingGate.get();

            gateFromDb.setGateNumber(gate.getGateNumber());
            gateFromDb.setAirport(gate.getAirport());

            return gateRestRepository.save(gateFromDb);
        } else {
            throw new RuntimeException("Gate not found with id: " + id);
        }
    }
}
