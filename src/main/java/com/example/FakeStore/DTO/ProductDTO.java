package com.example.FakeStore.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    String title;
    Integer price;
    String description;
}
