package com.example.FakeStore.Gateway;

import com.example.FakeStore.DTO.CategoryDTO;
import com.example.FakeStore.Gateway.Api.FakeStoreCategoryApi;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway{

    private FakeStoreCategoryApi fakeStoreCategoryApi;

    public FakeStoreCategoryGateway(FakeStoreCategoryApi _fakeStoreCategoryApi){
        fakeStoreCategoryApi=_fakeStoreCategoryApi;
    }
    @Override
    public List<CategoryDTO> getAllCategories() {
       return new ArrayList<CategoryDTO>();
    }
}
