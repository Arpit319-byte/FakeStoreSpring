package com.example.FakeStore.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FakeStoreProductResponseDTO {

    String status;
    String message;
    List<String> products;
}
