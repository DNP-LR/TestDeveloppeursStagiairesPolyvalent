package com.example.testdeveloppeursstagiairespolyvalent.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String email;
    private String userName;
    private String fullName;
    private String token;
    private String createdAtString;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String updatedAtString;

}
