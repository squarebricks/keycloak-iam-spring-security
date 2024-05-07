package com.popcorn.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminDto {
    private UUID adminId;
    private String name;
    private String email;
}
