package com.test.cryptotrackapp.dto.converter;

import com.test.cryptotrackapp.dto.user.CreateUserRequest;
import com.test.cryptotrackapp.dto.user.UserDto;
import com.test.cryptotrackapp.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserConverter {

    private final ModelMapper modelMapper;

    public User convert(CreateUserRequest createUserRequest) {
        return modelMapper.map(createUserRequest, User.class);
    }

    public UserDto convert(User user) {
        return modelMapper.map(user, UserDto.class);
    }
}
