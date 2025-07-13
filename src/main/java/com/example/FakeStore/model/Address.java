package com.example.FakeStore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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

    @OneToOne
    @JoinColumn(name = "geolocation_id", referencedColumnName = "id")
    private GeoLocation geolocation;

    @OneToOne(mappedBy = "address")
    private User user;


}
