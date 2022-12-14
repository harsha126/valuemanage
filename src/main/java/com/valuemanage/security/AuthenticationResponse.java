package com.valuemanage.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthenticationResponse {
    private final String accessToken;
    private final String role;
    private final String name;
}
