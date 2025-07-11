package com.example.FakeStore.Service;

import com.example.FakeStore.DTO.ProductDTO;
import com.example.FakeStore.Repository.ProductRepository;
import com.example.FakeStore.model.Product;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService implements IProductService {
    // This is a placeholder service implementation for ProductService.

    private final ProductRepository productRepository;

    public ProductService(ProductRepository _productRepository) {
        this.productRepository = _productRepository;
    }

    @Override
    public List<ProductDTO> getAllProduct() throws IOException {
        // This method fetches all products from the repository layer
        List<Product> products = productRepository.findAll();
       return products.stream()
               .map(product -> ProductDTO.builder()
                       .id(product.getId())
                       .title(product.getTitle())
                       .price(product.getPrice())
//                       .category(product.getCategory())
                       .description(product.getDescription())
                       .build())
               .toList();
    }

    @Override
    public ProductDTO getProductById(long id) throws IOException {
        return null;
    }

    @Override
    public List<ProductDTO> getProductByCategory() throws IOException {
        return List.of();
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) throws IOException {
        return null;
    }

    @Override
    public boolean deleteProductById(Long id) throws IOException {
        return false;
    }
}
