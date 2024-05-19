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

    public Boolean addBook(String nomeLivro){
        var json = consumo.obterDados(ENDERECO + "?search=" + nomeLivro.replace(" ", "%20"));
        System.out.println(ENDERECO + "?search=" + nomeLivro.replace(" ", "%20"));
        ApiData apiData = conversor.obterDados(json, ApiData.class);

        if(apiData.count() > 0){
            List<BookData> rawBookData = apiData.results();

            rawBookData.stream().forEach( book -> {
                    bookRepository.save(new Book(book))
//                    todo: criar o método para exibir o livro
                    })
            );

//            ToDo: Criar procedimento para verificar se não tem próximo link
        }



    }

}
