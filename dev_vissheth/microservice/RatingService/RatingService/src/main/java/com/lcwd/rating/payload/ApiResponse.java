package com.lcwd.rating.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@val
public class ApiResponse {
    private String msg;
    private boolean success;
    private HttpStatus status;
}
