package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PersonData(
        Long id,
        String name,
        Integer birthYear,
        Integer deathYear) {
}
