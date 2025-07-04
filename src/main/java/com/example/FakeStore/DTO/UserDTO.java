package com.example.FakeStore.DTO;
// This class is a placeholder for User Data Transfer Object (DTO).

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private String id;
    private String email;
    private String username;
    private String password;
//    private String name;
//    private String address;
//    private String phoneNumber;
}
