package com.example.FakeStore.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    Long id;
    String title;
    String image;
    Double price;
    String description;
    String brand;
    String model;
    boolean popular;
    double discount;
}
