package com.example.FakeStore.DTO;

import com.google.gson.annotations.SerializedName;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GeoLocationDTO{

    private Double lat;
    private Double lng;

}