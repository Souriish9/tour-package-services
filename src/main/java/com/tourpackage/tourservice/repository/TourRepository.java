package com.tourpackage.tourservice.repository;

import com.tourpackage.tourservice.models.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Long> {
    List<Tour> findByLocationIgnoreCase(String location);
}
