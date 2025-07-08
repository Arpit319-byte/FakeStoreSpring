package com.example.FakeStore.Gateway;

import com.example.FakeStore.DTO.ProductDTO;

import java.io.IOException;
import java.util.List;

public interface IProductGateway {

    // This interface defines the methods for interacting with the product data source.

    // Fetches all products
    List<ProductDTO> getAllProduct() throws IOException;

    // Fetches a product by its ID
     List<ProductDTO> getProductById() throws IOException;

    // Fetches products by category
    List<ProductDTO> getProductByCategory() throws IOException;

    // Creates a new product
     ProductDTO createProduct(ProductDTO productDTO) throws IOException;

    // Deletes a product by its ID
     boolean deleteProductById(Long id) throws IOException;

}
