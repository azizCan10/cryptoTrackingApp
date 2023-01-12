package com.test.cryptotrackapp.service;

import com.test.cryptotrackapp.dto.Crypto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class CryptoService {

    private final RestTemplate restTemplate;

    public Crypto getAvgPrice(String symbol) {
        Crypto crypto = restTemplate.getForObject("https://api1.binance.com/api/v3/avgPrice?symbol=" + symbol, Crypto.class);
        crypto.setSymbol(symbol);

        return crypto;
    }


}
