package com.test.cryptotrackapp.controller;

import com.test.cryptotrackapp.service.CryptoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/crypto")
public class CryptoController {

    private final CryptoService cryptoService;

    @GetMapping("/price/{symbol}")
    public ResponseEntity<?> getAvgPrice(@PathVariable String symbol) {
        return ResponseEntity.ok(cryptoService.getAvgPrice(symbol));
    }
}
