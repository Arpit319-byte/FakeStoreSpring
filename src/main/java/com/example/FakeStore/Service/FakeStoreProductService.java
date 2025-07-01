package com.example.FakeStore.Service;

import com.example.FakeStore.DTO.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreProductService implements IProductService {
    @Override
    public List<ProductDTO> getAllProduct() {
        return List.of();
    }
}
