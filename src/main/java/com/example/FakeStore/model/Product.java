package com.example.FakeStore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Product extends BaseEntity {

    private Long id;
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
