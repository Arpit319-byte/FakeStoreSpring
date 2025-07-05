package com.example.FakeStore.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FakeStoreSingleUserResponseDTO {
    String status;
    String message;
    UserDTO user;
}
