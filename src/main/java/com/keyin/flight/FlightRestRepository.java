package com.keyin.flight;

import org.springframework.data.repository.CrudRepository;

public interface FlightRestRepository extends CrudRepository<Flight, Long> {
}