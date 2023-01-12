package com.test.cryptotrackapp.dto.user;

import com.test.cryptotrackapp.dto.Crypto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String firstName;
    private String lastName;
    private String username;
    //    private List<String> trackedCryptos;
    private List<Crypto> trackedCryptos;

}
