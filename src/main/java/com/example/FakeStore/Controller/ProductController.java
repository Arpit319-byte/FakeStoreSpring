package com.example.FakeStore.Controller;

import com.example.FakeStore.DTO.ProductDTO;
import com.example.FakeStore.Service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ProductController.class);
    private final IProductService productService;

    public ProductController(@Qualifier("ProductService") IProductService productService){
      this.productService = productService;
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() throws IOException {
        // This method fetches all products from the service layer
        logger.info("Fetching all products from the FakeStoreService Layer");
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable long id) throws IOException {
        // This method can be implemented to fetch a product by its ID
        logger.info("Fetching product by ID from the FakeStoreService Layer");
        return productService.getProductById(id);
    }

    @GetMapping("/category/type")
    public List<ProductDTO> getProductByCategory() throws IOException {
        // This method can be implemented to fetch products by category
        logger.info("Fetching products by category from the FakeStoreService Layer");
        return productService.getProductByCategory();
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO) throws IOException {
        // This method can be implemented to create a new product

        logger.info("Creating a new product in the FakeStoreService Layer");
        ProductDTO createdProduct = productService.createProduct(productDTO);
        if (createdProduct == null) {
            logger.error("Failed to create product: {}", productDTO);
            return ResponseEntity.status(400).build(); // Bad Request
        }
        return ResponseEntity.status(201).body(createdProduct); // Created
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id) throws IOException {
        // This method can be implemented to delete a product by its ID
        logger.info("Deleting product by ID from the FakeStoreService Layer");
        boolean isDeleted = productService.deleteProductById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Product deleted successfully");
        } else {
            logger.error("Failed to delete product with ID {}", id);
            return ResponseEntity.status(404).body("Product not found"); // Not Found
        }
    }
}
