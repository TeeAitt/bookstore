package hh.swd20.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

	//CrudRepository provides CRUD (create, read, update, delete) functions for the entity class, that is managed.
	// In this situation the entity class is the Book class.
public interface BookRepository extends CrudRepository<Book, Long> {

	
}
