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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCityById(@PathVariable Long id){
        cityService.deleteCityById(id);
        return ResponseEntity.ok("City with id " + id + " deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCity(@PathVariable Long id, @RequestBody City city){
        cityService.updateCity(id, city); // saves
        return ResponseEntity.ok("City with id " + id + " updated successfully");
    }


}
