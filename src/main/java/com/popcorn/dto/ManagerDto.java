package com.popcorn.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ManagerDto {
    private UUID managerId;
    private String name;
    private String email;
}
