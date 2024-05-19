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
    @Column(unique=true)
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

    @Override
    public String toString() {
        String livro = """
                Livro:
                    nome: %s
                    idiomas: %s
                    autores: %s
                    categorias: %s
                    downloads: %d
                """;
       return String.format(livro, this.title, this.languages, this.authors, this.subjects, this.downloadCount);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPublicId() {
        return publicId;
    }

    public void setPublicId(Long publicId) {
        this.publicId = publicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<Person> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Person> authors) {
        this.authors = authors;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }
}
