package com.test.cryptotrackapp.dto.converter;

import com.test.cryptotrackapp.dto.CryptoDto;
import com.test.cryptotrackapp.model.Crypto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CryptoConverter {

    private final ModelMapper modelMapper;

    public CryptoDto convert(Crypto crypto) {
        return modelMapper.map(crypto, CryptoDto.class);
    }
}
