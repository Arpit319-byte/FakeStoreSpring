package com.example.FakeStore.DTO;

import com.example.FakeStore.model.GeoLocation;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDTO{

    private String city;
    private String street;
    private String number;
    private String zipcode;
    private GeoLocationDTO geoLocation;

}