package com.keyin.flight;

import com.keyin.aircraft.Aircraft;
import com.keyin.airport.Airport;
import com.keyin.gate.Gate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FlightRestRepository extends CrudRepository<Flight, Long> {
    Flight getFlightByFlightNumber(Flight flightNumber);

    Optional<Flight> findFlightByDepartureTime(Flight departureTime);

    Optional<Flight> findFlightByArrivalTime(Flight arrivalTime);

    Iterable<Flight> findFlightsByOriginAirport(Flight originAirport);

    Iterable<Flight> findFlightsByDestinationAirport(Flight destinationAirport);

    Iterable<Flight> findFlightsByAircraft(Flight aircraft);

    Iterable<Flight> findByGate(Gate gate);
}
