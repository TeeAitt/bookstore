package hh.swd20.bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity	 // Describes the structure of the database table that is corresponding to the class
		 // table name, column names and data types, primary key etc. In short: an entity represents a table in relational database.
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)// Automatically generates new primary key values (in this it's the id), when new information is inputed in the table.
	private long id;
	private String name;
	
	// This annotation is the other end of the relationship annotations.
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category") // The "category" tells to which attribute this annotation will be linked, in other words: mapped.
	private List<Book> books;  // The type is a list here, because Category can have many Book items, in contrast to Book that can only have on Category. 
	
	public Category() {
		
	}
	
	public Category(String name) {
		super();
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		// Don't add the book list here, that would cause an infinite loop.
		return "Category [id=" + id + ", name=" + name + "]";
	}

}
