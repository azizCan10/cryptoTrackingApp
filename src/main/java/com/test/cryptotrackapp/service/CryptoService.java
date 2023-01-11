package com.test.cryptotrackapp.service;

import com.test.cryptotrackapp.dto.AvgPriceConverter;
import com.test.cryptotrackapp.dto.AvgPriceDto;
import com.test.cryptotrackapp.model.AvgPrice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class CryptoService {

    private final RestTemplate restTemplate;
    private final AvgPriceConverter converter;

    public AvgPriceDto getAvgPrice(String symbol) {
        AvgPrice avgPrice = restTemplate.getForObject("https://api1.binance.com/api/v3/avgPrice?symbol=" + symbol, AvgPrice.class);
        avgPrice.setSymbol(symbol);

        return converter.convert(avgPrice);
    }


}
