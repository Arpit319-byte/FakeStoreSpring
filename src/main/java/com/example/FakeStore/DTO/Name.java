package com.example.FakeStore.DTO;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Name{

    @SerializedName("firstname")
    private String firstname;

    @SerializedName("lastname")
    private String lastname;
}