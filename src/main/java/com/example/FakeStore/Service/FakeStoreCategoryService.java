package com.example.FakeStore.Service;

import com.example.FakeStore.DTO.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCategoryService implements ICategoryService {

    @Override
    public List<ProductDTO> getAllCategory() {
        return new ArrayList<>();
    }
}
