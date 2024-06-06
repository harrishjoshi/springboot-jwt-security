package com.harxsh.jwt.security.book;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BookResponse(
        Integer id,
        String title,
        String description,
        LocalDateTime createDate,
        LocalDateTime lastModified,
        Integer createdBy,
        Integer lastModifiedBy
) {
}
