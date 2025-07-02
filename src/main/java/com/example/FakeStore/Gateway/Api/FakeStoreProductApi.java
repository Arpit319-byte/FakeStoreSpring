package com.example.FakeStore.Gateway.Api;

import com.example.FakeStore.DTO.FakeStoreProductResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface FakeStoreProductApi {
    @GET("products")
    Call<FakeStoreProductResponseDTO> getAllProducts();

    @GET("products/2")
    Call<FakeStoreProductResponseDTO> getProductById();

    @GET("products/category?type=mobile")
    Call<FakeStoreProductResponseDTO> getProductByCategory();
}
