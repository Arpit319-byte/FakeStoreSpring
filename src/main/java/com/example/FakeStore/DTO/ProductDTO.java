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
    Double price;
    String description;
}
