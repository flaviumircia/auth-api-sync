package com.syncpeer.authapi.auth.controller;


import com.syncpeer.authapi.auth.AuthenticationRequest;
import com.syncpeer.authapi.auth.AuthenticationResponse;
import com.syncpeer.authapi.auth.RegisterRequest;
import com.syncpeer.authapi.auth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.syncpeer.authapi.utils.Constants.API_BASE_PATH;
import static com.syncpeer.authapi.utils.Constants.AUTH;

@RestController
@RequestMapping(API_BASE_PATH+AUTH)
@Slf4j
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));

    }
}
