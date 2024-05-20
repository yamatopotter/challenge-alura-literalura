package com.alura.literalura.service;

import com.alura.literalura.model.Book;
import com.alura.literalura.model.Language;
import com.alura.literalura.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    @Autowired
    private LanguageRepository languageRepository;

    public void listBooksByLanguage(String language){
        Optional<Language> isThereLanguage = languageRepository.findByLanguage(language);
        if(isThereLanguage.isPresent()){
            isThereLanguage.get().getBooks().stream()
                    .forEach(System.out::println);
        }
        else{
            System.out.println("Não foram encontrados livros com esse idioma");
        }
    }

    public void listAllLanguages(){
        List<Language> languages = languageRepository.findAll();
        languages.stream()
                .forEach(l -> System.out.println("Idioma: "+l.getLanguage()));
    }

}
