package com.example.FakeStore.Service;

import com.example.FakeStore.DTO.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {

    public List<CategoryDTO> getAllCategory() throws IOException;
}
