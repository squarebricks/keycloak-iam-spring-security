package com.popcorn.controller;

import com.google.gson.Gson;
import com.popcorn.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private static final List<UserDto> users = new ArrayList<>();

    private final Gson jsonHelper;

    @PreAuthorize("hasAnyRole('client_user', 'client_employee', 'client_manager', 'client_hr', 'client_admin')")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<UserDto>> getAllUsers(Authentication authentication) {
        log.info("UserController::getAllUsers");
        return ResponseEntity.status(HttpStatus.OK)
                .body(users);
    }
}
