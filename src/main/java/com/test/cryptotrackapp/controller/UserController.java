package com.test.cryptotrackapp.controller;

import com.test.cryptotrackapp.dto.user.CreateUserRequest;
import com.test.cryptotrackapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody CreateUserRequest user) {
        return ResponseEntity.ok(userService.add(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping("/signin")
    public ResponseEntity<?> signIn(String username, String password) {
        return ResponseEntity.ok(userService.signIn(username, password));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        return ResponseEntity.ok(userService.delete(id));
    }
}
