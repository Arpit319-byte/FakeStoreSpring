package com.example.FakeStore.Gateway.Api;

import com.example.FakeStore.DTO.FakeStoreSingleUserResponseDTO;
import com.example.FakeStore.DTO.FakeStoreUserResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeStoreUserApi {

    @GET("users")
    Call<FakeStoreUserResponseDTO> getAllUsers();

    @GET("users/{id}")
    Call<FakeStoreSingleUserResponseDTO> getUserById(@Path("id") Long id);
}
