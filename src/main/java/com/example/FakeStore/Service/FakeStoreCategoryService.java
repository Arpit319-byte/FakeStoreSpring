package com.example.FakeStore.Service;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.FakeStore.DTO.CategoryDTO;
import com.example.FakeStore.Gateway.ICategoryGateway;

@Service
public class FakeStoreCategoryService implements ICategoryService {

    private static final Logger logger = LoggerFactory.getLogger(FakeStoreCategoryService.class);
    private final ICategoryGateway categoryGateway;

    public FakeStoreCategoryService(ICategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public List<CategoryDTO> getAllCategory() throws IOException {
        logger.info("Fetching the Category list from the GatewayLayer");
        return categoryGateway.getAllCategories();
    }
}
