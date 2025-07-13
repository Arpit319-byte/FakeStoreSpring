package com.example.FakeStore.model;

import com.example.FakeStore.DTO.Geolocation;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {

    private String email;
    private String password;
    private String username;
    private String phone;
    private String firstName;
    private String lastName;

    private Address address;
    private GeoLocation geolocation;


}
