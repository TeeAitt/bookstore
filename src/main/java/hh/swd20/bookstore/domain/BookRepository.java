package hh.swd20.bookstore.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

	//CrudRepository provides CRUD (create, read, update, delete) functions for the entity class, that is managed.
	// In this situation the entity class is the Book class.
public interface BookRepository extends CrudRepository<Book, Long> { // The <Book, Long> tells that the repository is for the Book entity and that the id type is Long.
	
	List<Book> findByTitle(String title);  // This method creates a findBuTitle query, which means that with it you can find (book) titles from the database (by making queries).

}
