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


    @SerializedName("password")
    private String password;

    @SerializedName("address")
    private Address address;

    @SerializedName("phone")
    private String phone;

    @SerializedName("name")
    private Name name;

    @SerializedName("id")
    private Integer id;

    @SerializedName("email")
    private String email;

    @SerializedName("username")
    private String username;
}
