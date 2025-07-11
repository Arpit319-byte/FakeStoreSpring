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

    Long id;
    String title;
    String image;
    Double price;
    String description;
    String brand;
    String model;
    boolean popular;
    double discount;


    // Additional fields can be added as needed
}
