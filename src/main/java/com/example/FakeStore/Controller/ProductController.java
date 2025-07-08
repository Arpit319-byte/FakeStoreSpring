package com.example.FakeStore.Controller;

import com.example.FakeStore.DTO.ProductDTO;
import com.example.FakeStore.Service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/Product")
public class ProductController {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ProductController.class);
    private final IProductService iProductService;

    public ProductController(IProductService _iProductService){
      this.iProductService=_iProductService;
    }

    @GetMapping
    public List<ProductDTO> getAllProduct() throws IOException {
        // This method fetches all products from the service layer
        logger.info("Fetching all products from the FakeStoreService Layer");
        return iProductService.getAllProduct();
    }

    @GetMapping("/{id}")
    public List<ProductDTO> getProductById() throws IOException {
        // This method can be implemented to fetch a product by its ID
        logger.info("Fetching product by ID from the FakeStoreService Layer");
        return iProductService.getProductById();
    }

    @GetMapping("/category/type")
    public List<ProductDTO> getProductByCategory() throws IOException {
        // This method can be implemented to fetch products by category
        logger.info("Fetching products by category from the FakeStoreService Layer");
        return iProductService.getProductByCategory();
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) throws IOException {
        // This method can be implemented to create a new product

        logger.info("Creating a new product in the FakeStoreService Layer");
        ProductDTO createdProduct = iProductService.createProduct(productDTO);
        if (createdProduct == null) {
            logger.error("Failed to create product: {}", productDTO);
            return ResponseEntity.status(400).build(); // Bad Request
        }
        return ResponseEntity.status(201).body(createdProduct); // Created
    }
}
