package com.example.FakeStore.Gateway.Api;

import com.example.FakeStore.DTO.FakeStoreProductResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface FakeStoreProductApi {
    @GET("https://fakestoreapi.in/api/products")
    Call<FakeStoreProductResponseDTO> getAllProducts();
}
