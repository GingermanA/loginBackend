package com.elgin.loginBackend.controller;

import com.elgin.loginBackend.entity.AuthRequest;
import com.elgin.loginBackend.entity.UserInfo;
import com.elgin.loginBackend.service.JwtService;
import com.elgin.loginBackend.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserInfoService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/user/home")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<UserInfo> userProfile(@RequestParam("username") String username) {
        return ResponseEntity.ok(service.getUserByUsername(username));
    }

    @GetMapping("/manager/home")
    @PreAuthorize("hasAuthority('MANAGER')")
    public ResponseEntity<UserInfo> managerProfile(@RequestParam("username") String username) {
        return ResponseEntity.ok(service.getUserByUsername(username));
    }

    @GetMapping("/manager/restricted")
    @PreAuthorize("hasAuthority('MANAGER')")
    public ResponseEntity<String> restricted() {
        return ResponseEntity.ok("Welcome to Restricted Page");
    }

    @PostMapping("/generateToken")
    public ResponseEntity<String> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return ResponseEntity.ok(jwtService.generateToken(authRequest.getUsername()));
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }

}
