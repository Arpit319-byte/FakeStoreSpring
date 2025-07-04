package com.example.FakeStore.Gateway.Api;

import com.example.FakeStore.DTO.FakeStoreUserResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FakeStoreUserApi {

    @GET("users")
    Call<FakeStoreUserResponseDTO> getAllUsers();
}
