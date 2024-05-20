package com.alura.literalura;

import com.alura.literalura.principal.Principal;
import com.alura.literalura.repository.BookRepository;
import com.alura.literalura.service.BookService;
import com.alura.literalura.service.LanguageService;
import com.alura.literalura.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	@Autowired
	private BookService service;
	@Autowired
	private PersonService personService;
	@Autowired
	private LanguageService languageService;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(service, personService, languageService);
		principal.exibeMenu();
	}
}
