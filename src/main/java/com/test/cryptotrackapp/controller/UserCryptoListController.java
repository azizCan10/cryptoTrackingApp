package com.test.cryptotrackapp.controller;

import com.test.cryptotrackapp.dto.userCryptoList.CreateUserCryptoListRequest;
import com.test.cryptotrackapp.service.UserCryptoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/v1/usercryptolist")
public class UserCryptoListController {

    private final UserCryptoListService userCryptoListService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody CreateUserCryptoListRequest userCryptoList) {
        return ResponseEntity.ok(userCryptoListService.add(userCryptoList));
    }
}
