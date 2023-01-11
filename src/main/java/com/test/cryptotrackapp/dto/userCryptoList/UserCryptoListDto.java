package com.test.cryptotrackapp.dto.userCryptoList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCryptoListDto {
    private long userId;
    private String symbol;
}
