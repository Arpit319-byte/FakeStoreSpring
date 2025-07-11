package com.example.FakeStore.Mapper;

import com.example.FakeStore.DTO.CategoryDTO;
import com.example.FakeStore.DTO.FakeStoreCategoryResponseDTO;
import com.example.FakeStore.DTO.ProductDTO;
import com.example.FakeStore.model.Product;

import java.util.List;

public class MapperClass {

    // This class is intended to map between different DTOs and entities.

    // Mapping ProductDTO to ProductEntity
    public static ProductDTO mapToProductDTO(Product product) {
        if (product == null) {
            return null;
        }

        return ProductDTO.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .description(product.getDescription())
                .image(product.getImage())
                .build();
    }

//     public FakeStoreCategoryResponseDTO mapToResponseDTO(List<CategoryDTO> categoryDTOs) {
//         // Implement mapping logic here
//
//
//     }
}
