package com.example.FakeStore.DTO;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FakeStoreSingleUserResponseDTO {

    @SerializedName("status")
    String status;

    @SerializedName("message")
    String message;


    UserDTO user;
}
