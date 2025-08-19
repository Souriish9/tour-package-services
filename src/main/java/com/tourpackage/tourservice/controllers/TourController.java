package com.tourpackage.tourservice.controllers;

import java.util.List;

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
    public Tour createTour(@RequestBody Tour tour) {
        return tourService.createTour(tour);
    }

    // 2. List All Tours OR By Location
    @Operation(summary = "Get all Tours or filter by location")
    @GetMapping
    public List<Tour> getAllTours(@RequestParam(required = false) String location) {
        if (location != null) {
            return tourService.getToursByLocation(location);
        }
        return tourService.getAllTours();
    }

    // 3. Get Tour by ID
    @Operation(summary = "Get Tour by ID")
    @GetMapping("/{id}")
    public Tour getTourById(@PathVariable Long id) {
        return tourService.getTourById(id);
    }
}
