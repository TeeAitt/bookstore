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
import hh.swd20.bookstore.domain.User;
import hh.swd20.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository userRepository) {  // With this, the database/table contents can be test in console, with the included demo content
		return (args) -> {
			log.info("Save some new categories and books, for demo purposes");
			Category category1 = new Category("Action");  // You don't need the id attribute, because it's auto generated.
			Category category2 = new Category("Adventure");
			Category category3 = new Category("Scifi");
			Category category4 = new Category("Mystery");
			
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);
			categoryRepository.save(category4);
			
			bookRepository.save(new Book("Librarians Lost Book", "Johnson", 1973, "96835", 22.99, category2));  // You don't need the id attribute, because it's auto generated.
			bookRepository.save(new Book("Streets of Darkness", "Smith", 2001, "94728", 7.99, category4));
			bookRepository.save(new Book("Travel Through Space", "Robertson", 1985, "98572", 19.99, category3));
			
			// Two default/demo users with passwords "user" and "admin" for the bookstore application.
			User user1 = new User("user", "$2y$10$zNShejIBvrQ9/xbUH1Jtoedcbg2PMORwh1BIpRbOWBpPSNeYZSdRS","user@user.com", "USER");
			User user2 = new User("admin", "$2y$10$xCBEgW5IKW/d0npWn.z1sO52VEMVG/7.xvuyIfVAuh4ZBLdXAx/ta", "admin@admin.com", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
			
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
