package hh.swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {  // With this, the database/table contents can be test in console, with the included demo content
		return (args) -> {
			log.info("Save some new categories and books, for demo purposes");
			Category category1 = new Category("Action");  // You don't need the id attribute, because it's auto generated.
			Category category2 = new Category("Adventure");
			Category category3 = new Category("Scifi");
			Category category4 = new Category("Romance");
			
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);
			categoryRepository.save(category4);
			
			bookRepository.save(new Book("The Lost Coding Temple", "Jackson", 2007, 98765, 19.99));  // You don't need the id attribute, because it's auto generated.
			bookRepository.save(new Book("The Battle for Grades", "Peterson", 1988, 94382, 17.99));
			bookRepository.save(new Book("Lightspeed Space Flying", "Nelson", 2013, 97465, 24.99));
			
			
			log.info("Fetch all categories");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}
			
			log.info("Fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
		
	}

}
