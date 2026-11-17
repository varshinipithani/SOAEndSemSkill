package com.tourist.touristjwt.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.tourist.touristjwt.service.JwtService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/token")
    public Map<String, String> generateToken(@RequestBody Map<String, String> data) {
        String username = data.get("username");
        String password = data.get("password");

        // Demo credentials only. Use a user database and password hashing in production.
        if (!"admin".equals(username) || !"1234".equals(password)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,
                    "Invalid username or password");
        }

        String token = jwtService.generateToken(username);
        return Map.of(
                "message", "Token generated successfully",
                "token", token,
                "tokenType", "Bearer"
        );
    }

    @GetMapping("/verify")
    public Map<String, String> verifyToken() {
        return Map.of(
                "status", "Success",
                "message", "JWT token is valid"
        );
    }
}
