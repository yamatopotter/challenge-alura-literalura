package com.alura.literalura.repository;

import com.alura.literalura.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LanguageRepository extends JpaRepository<Language, Long> {
    Optional<Language> findByLanguage(String language);
}
