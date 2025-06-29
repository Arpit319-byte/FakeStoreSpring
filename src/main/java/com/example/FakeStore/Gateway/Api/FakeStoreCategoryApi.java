package com.example.FakeStore.Gateway.Api;

import com.example.FakeStore.DTO.FakeStoreCategoryResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface FakeStoreCategoryApi {

    @GET
    Call<List<FakeStoreCategoryResponseDTO>> getAllCategories();
}
