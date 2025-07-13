package com.example.FakeStore.DTO;
// This class is a placeholder for User Data Transfer Object (DTO).

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    @SerializedName("firstName")
    private String firstName;

    @SerializedName("lastName")
    private String lastName;

    @SerializedName("password")
    private String password;

    @SerializedName("address")
    private AddressDTO address;

    @SerializedName("phone")
    private String phone;

    @SerializedName("email")
    private String email;

    @SerializedName("username")
    private String username;
}
