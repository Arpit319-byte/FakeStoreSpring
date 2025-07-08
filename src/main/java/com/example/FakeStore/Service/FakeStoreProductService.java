package com.example.FakeStore.Service;

import com.example.FakeStore.DTO.ProductDTO;
import com.example.FakeStore.Gateway.IProductGateway;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreProductService implements IProductService {

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(FakeStoreProductService.class);
    private final IProductGateway iProductGateway;
    private final IProductGateway iRestTemplateGateway;


    public FakeStoreProductService(@Qualifier("FakeStoreProductGateway") IProductGateway _iProductGateway,@Qualifier("FakeStoreRestTemplateGateway") IProductGateway _IRestTemplateGateway) {
        this.iProductGateway = _iProductGateway;
        this.iRestTemplateGateway = _IRestTemplateGateway;
    }

    @Override
    public List<ProductDTO> getAllProduct() throws IOException {
        // This method fetches all products from the gateway layer
        logger.info("Fetching all products from the FakeStoreProductService Layer");
        return iRestTemplateGateway.getAllProduct();
    }

    @Override
    public List<ProductDTO> getProductById() throws IOException {
        // This method can be implemented to fetch a product by its ID
        logger.info("Fetching product by ID from the FakeStoreProductService Layer");
        return iProductGateway.getProductById();
    }

    @Override
    public List<ProductDTO> getProductByCategory() throws IOException {
        // This method can be implemented to fetch products by category
        logger.info("Fetching products by category from the FakeStoreProductService Layer");
        return iProductGateway.getProductByCategory();
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) throws IOException {
        // This method can be implemented to create a new product
        logger.info("Creating a new product in the FakeStoreProductService Layer");
        ProductDTO createdProduct = iProductGateway.createProduct(productDTO);
        if (createdProduct == null) {
            logger.error("Failed to create product: {}", productDTO);
            return null; // If the product creation fails, return null
        }
        return createdProduct; // Return the created product
    }

    @Override
    public boolean deleteProductById(Long id) throws IOException {

        // This method can be implemented to delete a product by its ID
        logger.info("Deleting product by ID from the FakeStoreProductService Layer");
        boolean response = iRestTemplateGateway.deleteProductById(id);
        if (response) {
            logger.info("Product with ID {} deleted successfully", id);
            return true; // Return true if deletion was successful
        } else {
            logger.error("Failed to delete product with ID {}", id);
            return false; // Return false if deletion was unsuccessful
        }

    }
}
