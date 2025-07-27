package com.example.FakeStore.DTO;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private Long id;
    
    @NotBlank(message = "Product title is required")
    @Size(min = 2, max = 200, message = "Product title must be between 2 and 200 characters")
    private String title;
    
    @NotBlank(message = "Product image URL is required")
    @Pattern(regexp = "^(https?://).*", message = "Image must be a valid URL")
    private String image;
    
    @NotNull(message = "Product price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    @DecimalMax(value = "999999.99", message = "Price cannot exceed 999999.99")
    private Double price;
    
    @NotBlank(message = "Product description is required")
    @Size(min = 10, max = 1000, message = "Description must be between 10 and 1000 characters")
    private String description;
    
    @NotBlank(message = "Product brand is required")
    @Size(min = 2, max = 100, message = "Brand must be between 2 and 100 characters")
    private String brand;
    
    @Size(max = 100, message = "Model name cannot exceed 100 characters")
    private String model;
    
    private boolean popular;
    
    @DecimalMin(value = "0.0", message = "Discount cannot be negative")
    @DecimalMax(value = "100.0", message = "Discount cannot exceed 100%")
    private double discount;
}
