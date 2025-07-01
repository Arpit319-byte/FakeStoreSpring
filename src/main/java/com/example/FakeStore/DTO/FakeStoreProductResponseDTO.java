package com.example.FakeStore.DTO;

import com.example.FakeStore.model.Product;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FakeStoreProductResponseDTO {
    Integer id;
    String status;
    String message;
    List<Product> products;
}
