package com.example.FakeStore.Gateway;

import com.example.FakeStore.DTO.CategoryDTO;
import com.example.FakeStore.DTO.FakeStoreCategoryResponseDTO;
import com.example.FakeStore.Gateway.Api.FakeStoreCategoryApi;
import com.example.FakeStore.Service.FakeStoreCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway{

    private static final Logger logger = LoggerFactory.getLogger(FakeStoreCategoryGateway.class);

    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    public FakeStoreCategoryGateway(FakeStoreCategoryApi _fakeStoreCategoryApi){
        fakeStoreCategoryApi=_fakeStoreCategoryApi;
    }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        logger.info("Fetching the response from FakeStoreCategoryApi");
        FakeStoreCategoryResponseDTO response=fakeStoreCategoryApi.getAllCategories().execute().body();

        if (response == null) {
            logger.info("Response returned from FakeStoreCategoryApi is Null");
            throw new IOException("Response is null");
        }

        logger.info("Returning the Response in form of list of CategoryDTO");
        return response.getCategories().stream()
                .map(category->CategoryDTO.builder()
                        .name(category)
                        .build())
                .toList();
    }
}
