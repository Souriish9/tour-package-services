package com.tourpackage.tourservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tourpackage.tourservice.models.Tour;
import com.tourpackage.tourservice.repository.TourRepository;

@Service
public class TourService {

    private final TourRepository tourRepository;

    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public Tour createTour(Tour tour) {
        return tourRepository.save(tour);
    }

    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    public Tour getTourById(Long id) {
        Tour tour;
        try {
            tour = tourRepository.findById(id).get();
            if (tour == null)
                return null; // or throw an exception
            else
                return tour;
        } catch (Exception e) {
            return null; // or throw an exception
        }
    }

    public List<Tour> getToursByLocation(String location) {
        return tourRepository.findByLocationIgnoreCase(location);
    }
}
