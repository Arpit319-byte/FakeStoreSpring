package com.example.FakeStore.Service;

import com.example.FakeStore.DTO.UserDTO;
import com.example.FakeStore.Gateway.FakeStoreUserGateway;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreUserService implements IUserService {

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(FakeStoreUserService.class);
    private final FakeStoreUserGateway userGateway;

    public FakeStoreUserService(FakeStoreUserGateway _userGateway) {
        this.userGateway = _userGateway;
    }

    @Override
    public List<UserDTO> getAllUsers() throws IOException {
        // This method fetches all users from the user gateway layer
        logger.info("Fetching all users from the FakeStoreUserService Layer");
        return  userGateway.getAllUsers();
    }
}
