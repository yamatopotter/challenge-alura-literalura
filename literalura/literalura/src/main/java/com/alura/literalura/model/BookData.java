package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData (
        String title,
        List<String> subjects,
        List<String> languages,
        List<PersonData> authors,
        Integer downloadCount) {
}
