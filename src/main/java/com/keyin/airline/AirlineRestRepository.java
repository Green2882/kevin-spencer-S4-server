package com.keyin.airline;

import org.springframework.data.repository.CrudRepository;

public interface AirlineRestRepository extends CrudRepository<Airline, Long> {
}