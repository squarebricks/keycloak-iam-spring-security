package com.popcorn.controller;

import com.google.gson.Gson;
import com.popcorn.dto.AdminDto;
import lombok.Getter;
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
@RequestMapping("/api/v1/admins")
@RequiredArgsConstructor
@Slf4j
public class AdminController {
    private static final List<AdminDto> admins = new ArrayList<>();

    private final Gson jsonHelper;

    @PreAuthorize("hasAnyRole('client_admin')")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<AdminDto>> getAllAdmins(Authentication authentication) {
        log.info("AdminController::getAllAdmins");
        return ResponseEntity.status(HttpStatus.OK)
                .body(admins);
    }
}
