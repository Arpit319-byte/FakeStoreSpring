package com.example.FakeStore.Gateway;

import com.example.FakeStore.DTO.CategoryDTO;
import com.example.FakeStore.DTO.FakeStoreCategoryResponseDTO;
import com.example.FakeStore.Gateway.Api.FakeStoreCategoryApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway{

    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    public FakeStoreCategoryGateway(FakeStoreCategoryApi _fakeStoreCategoryApi){
        fakeStoreCategoryApi=_fakeStoreCategoryApi;
    }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        FakeStoreCategoryResponseDTO response=fakeStoreCategoryApi.getAllCategories().execute().body();

        if (response == null) {
           throw new IOException("Response is null");
        }
        return response.getCategories().stream()
                .map(category->CategoryDTO.builder()
                        .name(category)
                        .build())
                .toList();
    }
}
