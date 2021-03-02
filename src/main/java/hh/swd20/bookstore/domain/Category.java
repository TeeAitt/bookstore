package hh.swd20.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity	 // Describes the structure of the database table that is corresponding to the class
		 // table name, column names and data types, primary key etc. In short: an entity represents a table in relational database.
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)// Automatically generates new primary key values (in this it's the id), when new information is inputed in the table.
	private long id;
	private String name;
	
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

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	

}
