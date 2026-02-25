package com.keyin.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cities")
@CrossOrigin

public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<City>>getCityById(@PathVariable Long id){
        return ResponseEntity.ok(cityService.findCityById(id));
    }

    @GetMapping("/requestparam")
    public ResponseEntity<Optional<City>>getByIdRequestParameter(@RequestParam Long id){
        return ResponseEntity.ok(cityService.findCityById(id));
    }

    @GetMapping()
    public ResponseEntity<Iterable<City>> getAllCities(){
        return ResponseEntity.ok(cityService.findAllCities());
    }

    @PostMapping()
    public ResponseEntity<City> createCity(@RequestBody City city){
        return ResponseEntity.ok(cityService.createCity(city));
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteCityById(@RequestParam Long id){
        cityService.deleteCityById(id);
        return ResponseEntity.ok("City with id " + id + " deleted successfully");
    }

    @PutMapping("")
    public ResponseEntity<String> put(@RequestParam Long id, @RequestBody City city){
        Optional<City> cityOptional = cityService.findCityById(id);
        cityOptional.get().setName(city.getName());
        cityOptional.get().setPopulation(city.getPopulation());
        cityOptional.get().setState(city.getState());
        return ResponseEntity.ok("City with id " + id + " updated successfully");
    }


}
