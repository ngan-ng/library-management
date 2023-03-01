package com.application.courselibrary;

import com.application.courselibrary.entities.Category;
import com.application.courselibrary.entities.Publisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.application.courselibrary.entities.Author;
import com.application.courselibrary.entities.Book;
import com.application.courselibrary.service.BookService;

@SpringBootApplication
public class CourselibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourselibraryApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate(BookService bookService) {
		return (args) -> {
			Book book1 = new Book("Book 1", "Book name 1", "This is book 1");
			Author author1 = new Author("Author 1", "This is description 1");
			Category category1 = new Category("Book 1");
			Publisher publisher1 = new Publisher("Publisher 1");
			book1.addAuthor(author1);
			book1.addCatetory(category1);
			book1.addPublisher(publisher1);
			bookService.createBook(book1);

			Book book2 = new Book("Book 2", "Book name 2", "This is book 2");
			Author author2 = new Author( "Author 2", "This is description 2");
			Category category2 = new Category("Book 2");
			Publisher publisher2 = new Publisher("Publisher 2");
			book2.addAuthor(author2);
			book2.addCatetory(category2);
			book2.addPublisher(publisher2);
			bookService.createBook(book2);
		};
	}

}
