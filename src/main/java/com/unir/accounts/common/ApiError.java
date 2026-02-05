package com.unir.accounts.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ApiError {
    private String code;
    private String message;
    private LocalDateTime timestamp;
}