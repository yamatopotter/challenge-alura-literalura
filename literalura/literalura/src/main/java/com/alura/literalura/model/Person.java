package com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="pessoas")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long publicId;
    private String name;
    private Integer birthYear;
    private Integer deathYear;
    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    public Person() {
    }

    public Person(Long id, String name, Integer birthYear, Integer deathYear) {
        this.publicId = id;
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

    public Person (PersonData personData){
        this.publicId = personData.id();
        this.name = personData.name();
        this.birthYear = personData.birthYear();
        this.deathYear = personData.deathYear();
    }

    @Override
    public String toString() {
        String autor = """
                Autor:
                    nome: %s
                    Ano de nascimento: %d
                    Ano da morte: %d
                """;
        return String.format(autor, this.name, this.birthYear, this.deathYear);
    }
}
