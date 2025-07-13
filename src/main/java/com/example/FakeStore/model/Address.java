package com.example.FakeStore.model;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Address extends BaseEntity {

    private String city;
    private String street;
    private String number;
    private String zipcode;

    private GeoLocation geolocation;


}
