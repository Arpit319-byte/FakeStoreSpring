package com.example.FakeStore.Gateway;

import com.example.FakeStore.DTO.FakeStoreUserResponseDTO;
import com.example.FakeStore.DTO.UserDTO;
import com.example.FakeStore.Gateway.Api.FakeStoreUserApi;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreUserGateway implements IUserGateway{

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(FakeStoreUserGateway.class);
    private final FakeStoreUserApi fakeStoreUserApi;

    public FakeStoreUserGateway(FakeStoreUserApi _fakeStoreUserApi) {
        this.fakeStoreUserApi = _fakeStoreUserApi;
    }

    @Override
    public List<UserDTO> getAllUsers() throws IOException {
        logger.info("Fetching the User list from the GatewayLayer");
        FakeStoreUserResponseDTO response = fakeStoreUserApi.getAllUsers().execute().body();

        // Check if the response is null or if it contains a null user list
        if (response == null || response.getUser() == null) {
            logger.error("Failed to fetch users from the API or received null response");
            return List.of(); // Return an empty list if the response is null
        }

        return response.getUser().stream().map(
            user -> UserDTO.builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .build())
                .toList();

    }
}
