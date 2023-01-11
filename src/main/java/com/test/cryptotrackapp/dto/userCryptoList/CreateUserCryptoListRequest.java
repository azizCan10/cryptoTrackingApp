package com.test.cryptotrackapp.dto.userCryptoList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserCryptoListRequest {
    private long userId;

    private String symbol;
}
