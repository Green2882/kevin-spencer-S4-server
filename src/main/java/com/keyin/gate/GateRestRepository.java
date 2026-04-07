package com.keyin.gate;

import com.keyin.airport.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GateRestRepository extends CrudRepository<Gate, Long> {

    List<Gate> findByAirport(Airport airport);

    Optional<Gate> findByGateNumberAndAirport(String gateNumber, Airport airport);

    List<Gate> findByGateNumber(String gateNumber);
}
