package com.test.cryptotrackapp.dto.converter;

import com.test.cryptotrackapp.dto.userCryptoList.CreateUserCryptoListRequest;
import com.test.cryptotrackapp.dto.userCryptoList.UserCryptoListDto;
import com.test.cryptotrackapp.entity.UserCryptoList;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserCryptoListConverter {

    private final ModelMapper modelMapper;

    public UserCryptoList convert(CreateUserCryptoListRequest userCryptoList) {
        return modelMapper.map(userCryptoList, UserCryptoList.class);
    }

    public UserCryptoListDto convert(UserCryptoList userCryptoList) {
        return modelMapper.map(userCryptoList, UserCryptoListDto.class);
    }
}
