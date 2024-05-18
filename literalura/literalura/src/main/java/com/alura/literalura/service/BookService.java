package com.alura.literalura.service;

import com.alura.literalura.model.Book;
import com.alura.literalura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Boolean addBook(Book book){
        try{
            bookRepository.save(book);
            return true;
        }
        catch(Error e){
            System.out.println("Houve um erro ao salvar o livro:");
            System.out.println(e.getMessage());
            return false;
        }
    }
}
