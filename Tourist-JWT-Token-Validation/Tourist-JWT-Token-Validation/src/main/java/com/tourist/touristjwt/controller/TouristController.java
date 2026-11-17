package com.tourist.touristjwt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.tourist.touristjwt.config.TouristData;
import com.tourist.touristjwt.model.Tourist;

@RestController
@RequestMapping("/api/tourists")
public class TouristController {
    private final TouristData touristData;

    public TouristController(TouristData touristData) {
        this.touristData = touristData;
    }

    @GetMapping
    public List<Tourist> getAllTourists() {
        return touristData.getAllTourists();
    }

    @GetMapping("/{id}")
    public Tourist getTouristById(@PathVariable int id) {
        Tourist tourist = touristData.getTouristById(id);
        if (tourist == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tourist not found");
        }
        return tourist;
    }

    @PostMapping
    public Tourist addTourist(@RequestBody Tourist tourist) {
        if (tourist.getName() == null || tourist.getDestination() == null
                || tourist.getCountry() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "name, destination and country are required");
        }
        return touristData.addTourist(tourist);
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "Tourist API is running");
    }
}
