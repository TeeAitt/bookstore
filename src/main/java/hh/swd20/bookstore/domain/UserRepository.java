package hh.swd20.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

	//CrudRepository provides CRUD (create, read, update, delete) functions for the entity class, that is managed.
	// In this situation the entity class is the User class.
public interface UserRepository extends CrudRepository<User, Long> {  // The <User, Long> tells that the repository is for the User entity and that the id type is Long.
	
	User findByUsername(String username);  // This method creates a findByUsername query, which means that with it you can find usernames from the database (by making queries).

}
