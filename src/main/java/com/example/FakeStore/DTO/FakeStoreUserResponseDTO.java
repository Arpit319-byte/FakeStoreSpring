package com.example.FakeStore.DTO;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FakeStoreUserResponseDTO {

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    List<UserDTO> users;
}