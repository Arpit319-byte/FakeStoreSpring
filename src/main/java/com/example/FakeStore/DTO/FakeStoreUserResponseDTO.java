package com.example.FakeStore.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FakeStoreUserResponseDTO {
    private String status;
    private String message;
    private List<UserDTO> user;
}
