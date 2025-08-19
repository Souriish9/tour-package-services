package com.tourpackage.tourservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tourpackage.tourservice.models.Tour;
import com.tourpackage.tourservice.service.TourService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/tours")
@Tag(name = "Tours", description = "Tour Packages APIs")
public class TourController {

    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    // 1. Create Tour
    @Operation(summary = "Create a new Tour")
    @PostMapping
    public ResponseEntity<Tour> createTour(@RequestBody Tour tour) {
        Tour createdTour = tourService.createTour(tour);
        if(createdTour != null) {
            return ResponseEntity.ok(createdTour);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    // 2. List All Tours OR By Location
    @Operation(summary = "Get all Tours or filter by location")
    @GetMapping
    public ResponseEntity<List<Tour>> getAllTours(@RequestParam(required = false) String location) {

        List<Tour> fetchedTours = new ArrayList<>();
        if (location != null) {
            fetchedTours = tourService.getToursByLocation(location);
            if(fetchedTours.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(fetchedTours);
        }
        fetchedTours = tourService.getAllTours();
        return ResponseEntity.ok(fetchedTours);
    }

    // 3. Get Tour by ID
    @Operation(summary = "Get Tour by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Tour> getTourById(@PathVariable Long id) {

        Tour fetchedTour = tourService.getTourById(id);
        if (fetchedTour == null) {
            return ResponseEntity.noContent().build();         
        }
        return ResponseEntity.ok(fetchedTour);
    }
}
