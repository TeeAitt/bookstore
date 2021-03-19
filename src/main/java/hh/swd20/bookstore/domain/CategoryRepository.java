package hh.swd20.bookstore.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

	// CrudRepository provides CRUD (create, read, update, delete) functions for the entity class, that is managed.
	// In this situation the entity class is the Category class.
public interface CategoryRepository extends CrudRepository<Category, Long> { // The <Category, Long> tells that the repository is for the Category entity and that the id type is Long.
	
	List<Category> findByName(String name);  // This method creates a findByName query, which means that with it you can find (category) names from the database (by making queries).
	
}
