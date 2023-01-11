package com.test.cryptotrackapp.service;

import com.test.cryptotrackapp.dto.converter.CryptoConverter;
import com.test.cryptotrackapp.dto.CryptoDto;
import com.test.cryptotrackapp.model.Crypto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class CryptoService {

    private final RestTemplate restTemplate;
    private final CryptoConverter converter;

    public CryptoDto getAvgPrice(String symbol) {
        Crypto crypto = restTemplate.getForObject("https://api1.binance.com/api/v3/avgPrice?symbol=" + symbol, Crypto.class);
        crypto.setSymbol(symbol);

        return converter.convert(crypto);
    }


}
