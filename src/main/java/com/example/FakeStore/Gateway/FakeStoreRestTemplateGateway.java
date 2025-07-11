package com.example.FakeStore.Gateway;

import com.example.FakeStore.DTO.FakeStoreProductResponseDTO;
import com.example.FakeStore.DTO.FakeStoreSingleProductResponseDTO;
import com.example.FakeStore.DTO.ProductDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Component("FakeStoreRestTemplateGateway")
public class FakeStoreRestTemplateGateway implements IProductGateway{

    // This class is a placeholder for the actual implementation of the gateway.
    // It should use RestTemplate or WebClient to interact with the Fake Store API.

    private final RestTemplate restTemplate;

    public FakeStoreRestTemplateGateway(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<ProductDTO> getAllProduct() throws IOException {
        // This method should implement the logic to fetch all products using RestTemplate.
        String url = "https://fakestoreapi.in/api/products";
        try {
            FakeStoreProductResponseDTO products = restTemplate.getForObject(url, FakeStoreProductResponseDTO.class);
            if (products != null) {
                return products.getProducts().stream()
                        .map(product -> ProductDTO.builder()
                                .id(product.getId())
                                .title(product.getTitle())
                                .price(product.getPrice())
                                .description(product.getDescription())
                                .build())
                        .toList();
            } else {
                throw new IOException("No products found");
            }
        } catch (Exception e) {
            // Log the exception or handle it as needed
            System.err.println("Error fetching products: " + e.getMessage());
            throw new IOException("Error fetching products", e);
        }
    }

    @Override
    public ProductDTO getProductById(long id) throws IOException {
        // This method should implement the logic to fetch a product by its ID using RestTemplate.

        String url = "https://fakestoreapi.in/api/products/"+ id;

        try{
            FakeStoreSingleProductResponseDTO response = restTemplate.getForObject(url, FakeStoreSingleProductResponseDTO.class);

            if(response != null && response.getProduct() != null) {
                return response.getProduct();
            } else {
                throw new IOException("Product not found for ID: " + id);
            }

        } catch (Exception e) {
            // Log the exception or handle it as needed
            System.err.println("Error fetching product with ID " + id + ": " + e.getMessage());
            throw new IOException("Error fetching product by ID", e);
        }
    }

    @Override
    public List<ProductDTO> getProductByCategory() throws IOException {
        return List.of();
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) throws IOException {

        String url = "https://fakestoreapi.in/api/products";

        try{
            FakeStoreSingleProductResponseDTO response = restTemplate.postForObject(url, productDTO, FakeStoreSingleProductResponseDTO.class);
            if (response != null && response.getProduct() != null) {
                return response.getProduct();
            } else {
                throw new IOException("Failed to create product");
            }

        } catch (RuntimeException e) {
            // Log the exception or handle it as needed
            System.err.println("Error creating product: " + e.getMessage());
            throw new IOException("Error creating product", e);
        }
    }

    @Override
    public boolean deleteProductById(Long id) throws IOException {
        // This method should implement the logic to delete a product by its ID using RestTemplate.
        String url = "https://fakestoreapi.in/api/products/" + id;
        try {
            restTemplate.delete(url);
            return true; // Return true if the deletion was successful
        } catch (Exception e) {
            // Log the exception or handle it as needed
            System.err.println("Error deleting product with ID " + id + ": " + e.getMessage());
        }
        return false;
    }


}
