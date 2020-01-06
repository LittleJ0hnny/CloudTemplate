package com.okravtsiv.authservice.domain.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ExceptionDTO {

    private Integer code;
    private String status;
    private String message;
    private LocalDateTime timestamp;
    private String location;

    public ExceptionDTO(Integer code, String status, String message, LocalDateTime timestamp, String location) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        this.location = location;
    }
}
