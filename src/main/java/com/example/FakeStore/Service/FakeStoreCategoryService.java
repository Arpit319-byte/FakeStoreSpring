package com.example.FakeStore.Service;

import com.example.FakeStore.Controller.CategoryController;
import com.example.FakeStore.DTO.CategoryDTO;
import com.example.FakeStore.Gateway.FakeStoreCategoryGateway;
import com.example.FakeStore.Gateway.ICategoryGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCategoryService implements ICategoryService {

    private static final Logger logger = LoggerFactory.getLogger(FakeStoreCategoryService.class);
    private final ICategoryGateway iCategoryGateway;

    public FakeStoreCategoryService(ICategoryGateway _iCategoryGateway) {
        this.iCategoryGateway = _iCategoryGateway;
    }

    @Override
    public List<CategoryDTO> getAllCategory() throws IOException {
        logger.info("Fetching the Category list from the GatewayLayer");
        return iCategoryGateway.getAllCategories();
    }
}
