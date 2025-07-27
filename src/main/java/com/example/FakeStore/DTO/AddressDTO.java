package com.example.FakeStore.DTO;

import com.example.FakeStore.model.GeoLocation;
import com.google.gson.annotations.SerializedName;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDTO{

    @NotBlank(message = "City is required")
    @Size(min = 2, max = 100, message = "City must be between 2 and 100 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "City can only contain letters and spaces")
    private String city;
    
    @NotBlank(message = "Street is required")
    @Size(min = 5, max = 200, message = "Street must be between 5 and 200 characters")
    private String street;
    
    @NotBlank(message = "Building number is required")
    @Size(min = 1, max = 20, message = "Building number must be between 1 and 20 characters")
    private String number;
    
    @NotBlank(message = "Zipcode is required")
    @Pattern(regexp = "^[0-9]{5,10}$", message = "Zipcode must be between 5 and 10 digits")
    private String zipcode;
    
    @Valid
    private GeoLocationDTO geoLocation;

}