package hh.swd20.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.bookstore.webcontroller.BookController;
import hh.swd20.bookstore.webcontroller.CategoryController;
import hh.swd20.bookstore.webcontroller.UserController;

/**
*
* This is a "smoke testing", with which it can be tested that major functions of the software are working correctly.
* In this the test is that the context is creating controllers (book, category and user).
*
*/


@ExtendWith(SpringExtension.class)  // This tells JUnit to use Spring's testing support.
@SpringBootTest		// With this regular tests and some more special tests can be used the test different parts of the application (in this case, the Bookstore application).
class BookstoreApplicationTests {
	
	@Autowired
	private BookController bookController;
	
	@Autowired
	private CategoryController categoryController;
	
	@Autowired
	private UserController userController;

	@Test  // This annotation defines a method to be a test method. In this case it's tested that the BookController controller loads the context, in other words, that it is not null.
	void bookContextLoads() {
		assertThat(bookController).isNotNull();  // "assert" specifies object to be tested and what the outcome should be (i.e. assertThat("Hello World").contains("Hello));
	}
	
	@Test  // This tests that the CategoryController controller context is not null.
	void categContextLoads() {
		assertThat(categoryController).isNotNull();
	}
	
	@Test  // This tests that the UserController controller context is not null.
	void userContextLoads() {
		assertThat(userController).isNotNull();
	}
	

}
