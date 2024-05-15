package com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name="livros")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long title;
    private List<String> subjects;
    private List<String> languages;
    @ManyToMany
    @JoinTable(
            name = "livros_pessoas",
            joinColumns = @JoinColumn(name = "livros_id"),
            inverseJoinColumns = @JoinColumn(name = "pessoas_id"))
    private List<Person> authors;
    private Integer downloadCount;

    public Book() {
    }

    public Book(Long id, Long title, List<String> subjects, List<String> languages, List<Person> authors, Integer downloadCount) {
        this.id = id;
        this.title = title;
        this.subjects = subjects;
        this.languages = languages;
        this.authors = authors;
        this.downloadCount = downloadCount;
    }
}
