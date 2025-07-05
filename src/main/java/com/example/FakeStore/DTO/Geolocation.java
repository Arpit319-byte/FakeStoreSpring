package com.example.FakeStore.DTO;

import com.google.gson.annotations.SerializedName;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Geolocation{

    @SerializedName("lat")
    private Object lat;

    @SerializedName("long")
    private Object lon;
}