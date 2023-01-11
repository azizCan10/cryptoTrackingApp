package com.test.cryptotrackapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CryptoDto {
    private int mins;
    private BigDecimal price;
    private String symbol;
}
