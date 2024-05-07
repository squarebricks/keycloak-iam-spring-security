package com.popcorn.dto;

import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HRDto {
    private UUID hrId;
    private String name;
    private String email;
}
