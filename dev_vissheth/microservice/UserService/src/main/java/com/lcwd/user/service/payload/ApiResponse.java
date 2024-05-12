package com.lcwd.user.service.payload;

import org.springframework.http.HttpStatus;

public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatus status;

    // Getter for message
    public String getMessage() {
        return message;
    }

    // Setter for message
    public void setMessage(String message) {
        this.message = message;
    }

    // Getter for success
    public boolean isSuccess() {
        return success;
    }

    // Setter for success
    public void setSuccess(boolean success) {
        this.success = success;
    }

    // Getter for status
    public HttpStatus getStatus() {
        return status;
    }

    // Setter for status
    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    // Builder method
    public static ApiResponseBuilder builder() {
        return new ApiResponseBuilder();
    }

    // Builder class
    public static class ApiResponseBuilder {
        private ApiResponse apiResponse;

        public ApiResponseBuilder() {
            apiResponse = new ApiResponse();
        }

        public ApiResponseBuilder withMessage(String message) {
            apiResponse.setMessage(message);
            return this;
        }

        public ApiResponseBuilder withSuccess(boolean success) {
            apiResponse.setSuccess(success);
            return this;
        }

        public ApiResponseBuilder withStatus(HttpStatus status) {
            apiResponse.setStatus(status);
            return this;
        }

        public ApiResponse build() {
            return apiResponse;
        }
    }
}
