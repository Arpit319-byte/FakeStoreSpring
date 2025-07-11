package com.example.FakeStore.Service;

import com.example.FakeStore.DTO.ProductDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService implements IProductService {
    // This is a placeholder service implementation for ProductService.

    @Override
    public List<ProductDTO> getAllProduct() throws IOException {
        return List.of();
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
