package com.example.FakeStore.Gateway;

import com.example.FakeStore.DTO.CategoryDTO;
import java.util.List;

public interface ICategoryGateway {
    List<CategoryDTO> getAllCategories();
}
