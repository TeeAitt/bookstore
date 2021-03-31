package hh.swd20.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;
import hh.swd20.bookstore.domain.User;
import hh.swd20.bookstore.domain.UserRepository;

@ExtendWith(SpringExtension.class)  // This tells JUnit to use Spring's testing support.
@DataJpaTest
public class RepositoryTest {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test  // This tests that BookRepository's findByTitle method works correctly.
	public void findByTitleShouldReturnBook() {
		List<Book> books = bookRepository.findByTitle("Streets of Darkness");  // This defines what already existing book title to use for the testing (demo books in the BookstoreApplication class). 
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Smith");  // This specifies what is the name of the author that should return for the previously specified book title.
	}
	
	@Test  // This tests that CategoryRepository's findByName method works correctly.
	public void findByNameShouldReturnCategory() {
		List<Category> categories = categoryRepository.findByName("Scifi");
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName()).isEqualTo("Scifi");
	}
	
	@Test  // This tests that UserRepository's findByUsername method works correctly.
	public void findByUsernameShouldReturnUser() {
		User users = userRepository.findByUsername("admin");
		assertThat(users.getEmail()).isEqualTo("admin@admin.com");
	}
	
	@Test  // This tests that creating a new book works correctly.
	public void createNewBook() {
		Book book = new Book("Stories of the New World", "Anderson", 2008, "95629", 12.99, categoryRepository.findByName("Adventure").get(0));
		bookRepository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test  // This tests that creating a new category works correctly.
	public void createNewCategory() {
		Category category = new Category("Horror");
		categoryRepository.save(category);
		assertThat(category.getId()).isNotNull();
	}
	
	@Test  // This tests that creating a new user works correctly.
	public void createNewUser() {
		User user = new User("matt", "$2y$10$R93LYAN/l2G8wiDtiY3cLe.0/0rA7vIDzyq5jn/KaH0.faKu6cdq2", "matt@matt.com", "USER");
		userRepository.save(user);
		assertThat(user.getId()).isNotNull();
	}


}
