package com.example.FakeStore.DTO;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address{

    @SerializedName("zipcode")
    private String zipcode;

    @SerializedName("number")
    private String number;

    @SerializedName("city")
    private String city;

    @SerializedName("street")
    private String street;

    @SerializedName("geolocation")
    private Geolocation geolocation;
}