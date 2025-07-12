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
                .brand(product.getBrand())
                .model(product.getModel())
                .popular(product.isPopular())
                .discount(product.getDiscount())
                .build();
    }

    // Mapping ProductEntity to ProductDTO
    public static Product mapToProductEntity(ProductDTO productDTO) {

        if (productDTO == null) {
            return null;
        }

        return Product.builder()
                .id(productDTO.getId())
                .title(productDTO.getTitle())
                .price(productDTO.getPrice())
                .description(productDTO.getDescription())
                .image(productDTO.getImage())
                .brand(productDTO.getBrand())
                .model(productDTO.getModel())
                .popular(productDTO.isPopular())
                .discount(productDTO.getDiscount())
                .build();
    }


}
