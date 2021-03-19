package hh.swd20.bookstore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	
	// With the Column annotation the id attribute can be assigned with mandatory features, it cannot be empty and it cannot be updated.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	
	// The username cannot be empty and it needs to be unique (so, two same username is not possible in the database).
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "passwordHash", nullable = false)
	private String passwordHash;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "role", nullable = false)
	private String role;
	
	public User() {
		
	}
	
	public User(String username, String passwordHash, String email, String role) {
	super();
	this.username = username;
	this.passwordHash = passwordHash;
	this.email = email;
	this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


}
