package com.keyin.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRestRepository cityRestRepository;
    @Autowired
    private CityService cityService;

    public City createCity(City city){
        return cityRestRepository.save(city);
    }

    public Iterable<City> findAllCities(){
        return cityRestRepository.findAll();
    }

    public Optional<City> findCityById(Long id){
        return cityRestRepository.findById(id);
    }

    public void deleteCityById(Long id){
        cityRestRepository.deleteById(id);
    }

    public City updateCity(Long id, City city) {

        Optional<City> existingCity = cityRestRepository.findById(id);

        if (existingCity.isPresent()) {

            City cityFromDb = existingCity.get();

            cityFromDb.setName(city.getName());
            cityFromDb.setState(city.getState());
            cityFromDb.setPopulation(city.getPopulation());

            return cityRestRepository.save(cityFromDb);

        } else {
            throw new RuntimeException("City not found");
        }
    }

}
