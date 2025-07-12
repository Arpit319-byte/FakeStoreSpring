package com.example.FakeStore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
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
