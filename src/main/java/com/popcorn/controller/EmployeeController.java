package com.popcorn.controller;

import com.google.gson.Gson;
import com.popcorn.dto.EmployeeDto;
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
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {
    private static final List<EmployeeDto> employees = new ArrayList<>();

    private final Gson jsonHelper;

    @PreAuthorize("hasAnyRole('client_employee', 'client_manager', 'client_hr', 'client_admin')")
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(Authentication authentication) {
        log.info("EmployeeController::getAllEmployees");
        return ResponseEntity.status(HttpStatus.OK)
                .body(EmployeeController.employees);
    }
}
