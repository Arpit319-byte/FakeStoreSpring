package com.example.FakeStore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    private String title;
    private String image;
    private Double price;
    private String description;
    private String brand;
    private String model;
    private boolean popular;
    private double discount;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
