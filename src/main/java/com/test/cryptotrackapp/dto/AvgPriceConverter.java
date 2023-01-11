package com.test.cryptotrackapp.dto;

import com.test.cryptotrackapp.model.AvgPrice;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AvgPriceConverter {

    private final ModelMapper modelMapper;

    public AvgPriceDto convert(AvgPrice avgPrice) {
        return modelMapper.map(avgPrice, AvgPriceDto.class);
    }
}
