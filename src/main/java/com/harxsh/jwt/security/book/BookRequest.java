package com.harxsh.jwt.security.book;

import jakarta.validation.constraints.NotEmpty;

public record BookRequest(
        @NotEmpty(message = "Title is required")
        String title,
        @NotEmpty(message = "Description is required")
        String description
) {
}
