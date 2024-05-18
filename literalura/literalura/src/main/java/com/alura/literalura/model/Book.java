package com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name="livros")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long publicId;
    private String title;
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

    public Book(Long id, String title, List<String> subjects, List<String> languages, List<Person> authors, Integer downloadCount) {
        this.publicId = id;
        this.title = title;
        this.subjects = subjects;
        this.languages = languages;
        this.authors = authors;
        this.downloadCount = downloadCount;
    }

    public Book(BookData bookData){
        List<Person> authors = bookData.authors().stream().map(Person::new).collect(Collectors.toList());

        this.publicId = bookData.id();
        this.title = bookData.title();
        this.subjects = bookData.subjects();
        this.languages = bookData.languages();
        this.authors = authors;
        this.downloadCount = bookData.downloadCount();
    }
}
