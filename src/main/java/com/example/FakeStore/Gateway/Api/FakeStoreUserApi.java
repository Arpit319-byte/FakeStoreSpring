package com.example.FakeStore.Gateway.Api;

import com.example.FakeStore.DTO.FakeStoreSingleUserResponseDTO;
import com.example.FakeStore.DTO.FakeStoreUserResponseDTO;
import com.example.FakeStore.DTO.UserDTO;
import retrofit2.Call;
import retrofit2.http.*;

public interface FakeStoreUserApi {

    @GET("users")
    Call<FakeStoreUserResponseDTO> getAllUsers();

    @GET("users/{id}")
    Call<FakeStoreSingleUserResponseDTO> getUserById(@Path("id") Long id);

    @POST("users")
    Call<FakeStoreSingleUserResponseDTO> createUser(@Body UserDTO userDTO);

    @DELETE("users/{id}")
    Call<FakeStoreUserResponseDTO> deleteUserById(@Path("id") Long id);

    @PUT("users/{id}")
    Call<FakeStoreSingleUserResponseDTO> updateUserById(@Path("id") Long id, @Body UserDTO userDTO);
}
