package com.valuemanage.controllers;

import com.valuemanage.domain.User;
import com.valuemanage.security.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final UserPrincipalDetailsService userPrincipalDetailsService;
    private final JwtTokenUtil jwtTokenUtil;

    @PostMapping("/auth")
    public ResponseEntity<?> createAccessToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
            );
        }catch (BadCredentialsException e){
            throw  new Exception("Incorrect Username password ",e);
        }
        try {
            final UserPrincipal userPrincipal = (UserPrincipal) userPrincipalDetailsService
                    .loadUserByUsername(authenticationRequest.getUsername());
            final User user = userPrincipal.getUser();
            System.out.println("-----------------------"+user.getUsername());
            System.out.println("-----------------------"+user.getRole());

            final String accessToken = jwtTokenUtil.generateToken(userPrincipal);
            return ResponseEntity.ok(new AuthenticationResponse(accessToken,user.getRole()));
        } catch (UsernameNotFoundException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("BAD CREDENTIALS");
        }

//        return ResponseEntity.badRequest().body("Illegal Id Access call");

    }

}
