package com.example.FakeStore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class GeoLocation {

    private Double lat;
    private Double longitude;

    @OneToOne(mappedBy = "geoLocation")
    private Address address;

}
