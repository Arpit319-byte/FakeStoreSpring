package com.example.FakeStore.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    String title;
    Integer price;
    String description;
}
