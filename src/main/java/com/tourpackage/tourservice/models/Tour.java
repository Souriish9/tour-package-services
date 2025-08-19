package com.tourpackage.tourservice.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    private String discountInPercentage;

    private String title;

    private String description;

    private String duration;

    private String actualPrice;

    private String discountedPrice;

    private String location;
}
