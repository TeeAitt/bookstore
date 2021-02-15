package hh.swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository) {  // With this, the database/table contents can be test in console, with the included demo content
		return (args) -> {
			log.info("Save some new books, for demo purposes");
			Book b1 = new Book("Adv", "Jack", 2007, 98765, 19.99);  // You don't need the id attribute, because it's auto generated.
			Book b2 = new Book("Action", "Peterson", 1988, 94382, 17.99);
			Book b3 = new Book("Romance", "Nelson", 2013, 97465, 24.99);
			
			bookRepository.save(b1);
			bookRepository.save(b2);
			bookRepository.save(b3);
			
			log.info("Fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
		
	}

}
