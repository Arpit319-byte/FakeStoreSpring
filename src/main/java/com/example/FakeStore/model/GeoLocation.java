package com.example.FakeStore.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class GeoLocation extends BaseEntity {

    private Double lat;
    private Double lng;

}
