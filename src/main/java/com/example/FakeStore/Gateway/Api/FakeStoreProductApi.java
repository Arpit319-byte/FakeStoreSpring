package com.example.FakeStore.Gateway.Api;

import com.example.FakeStore.DTO.FakeStoreProductResponseDTO;
import com.example.FakeStore.DTO.FakeStoreSingleProductResponseDTO;
import com.example.FakeStore.DTO.ProductDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface FakeStoreProductApi {
    @GET("products")
    Call<FakeStoreProductResponseDTO> getAllProducts();

    @GET("products/{id}")
    Call<FakeStoreSingleProductResponseDTO> getProductById(@Path("id") long id);

    @GET("products/category?type=mobile")
    Call<FakeStoreProductResponseDTO> getProductByCategory();

    @POST("products")
    Call<FakeStoreSingleProductResponseDTO> createProduct(@Body ProductDTO productDTO);
}
