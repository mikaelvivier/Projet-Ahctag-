package com.imt.demo.controller;

import com.imt.demo.dto.Brand;
import com.imt.demo.dto.CarJsonDto;
import com.imt.demo.service.CarService;
import com.imt.demo.model.Car;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {
    
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> createPlayer(@Valid @RequestBody PlayerJsonDto player) {
        playerService.savePlayer(
            new Car(
                car.getBrand().toString(),
                car.getColor(),
                car.getHorsePower())
        );
        
        return ResponseEntity.ok("saved !");
    }
    
    @GetMapping("/{brand}")
    public ResponseEntity<List<CarJsonDto>> getCars(@PathVariable String brand) {
        List<CarJsonDto> carsByBrand = carService.findCarsByBrand(brand)
                .stream()
                .map(car -> new CarJsonDto(Brand.valueOf(car.getBrand()), car.getColor(), car.getHorsePower()))
                .toList();
        
        return ResponseEntity.ok(carsByBrand);
    }
    
}
