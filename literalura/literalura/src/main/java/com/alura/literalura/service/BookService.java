package com.alura.literalura.service;

import com.alura.literalura.model.Book;
import com.alura.literalura.model.BookData;
import com.alura.literalura.model.ApiData;
import com.alura.literalura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "http://gutendex.com/books/";

    public void addBook(String nomeLivro) {
        var json = consumo.obterDados(ENDERECO + "?search=" + nomeLivro.replace(" ", "%20"));
        ApiData apiData = conversor.obterDados(json, ApiData.class);

        System.out.println(apiData);

        if (apiData.count() > 0) {
            saveBook(apiData.results());

            while(!apiData.next().isBlank()){
                json = consumo.obterDados(ENDERECO + "?search=" + nomeLivro.replace(" ", "%20"));
                apiData = conversor.obterDados(json, ApiData.class);
                saveBook(apiData.results());
            }
        }
    }

    public void saveBook(List<BookData> books){
        books.stream().forEach(book -> {
                    Book newBook = new Book(book);
                    try {
//                        todo: Adicionar os autores primeiros
//                        newBook.
                        bookRepository.save(newBook);
                    } catch (Error e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println(newBook);
                }
        );
    }

}
