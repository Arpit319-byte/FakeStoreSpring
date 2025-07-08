package com.example.FakeStore.DTO;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FakeStoreSingleProductResponseDTO {

    String status;
    String message;
    ProductDTO product;
}
