package com.example.FakeStore.model;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Product extends BaseEntity {

    private String title;
    private Integer price;
    private String description;
    private String category;
    private String image;
    private Integer ratingRate;
    private Integer ratingCount;

    // Additional fields can be added as needed
}
