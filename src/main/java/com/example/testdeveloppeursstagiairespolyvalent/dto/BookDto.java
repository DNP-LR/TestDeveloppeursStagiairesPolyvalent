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
public class BookDto {
    private Long id;
    private String bookName;
    private String bookDescription;
    private String bookType;
    private String createdAtString;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String updatedAtString;
}
