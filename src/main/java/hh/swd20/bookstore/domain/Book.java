package hh.swd20.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity		// Describes the structure of the database table that is corresponding to the class
			// table name, column names and data types, primary key etc. In short: an entity represents a table in relational database.
public class Book {
	@Id		// Sets the primary key. It annotates an attribute to be the primary key. In this the attribute is named id (as well).
	@GeneratedValue(strategy=GenerationType.AUTO)  // Automatically generates new primary key values (in this it's the id), when new information is inputed in the table.
	private long id;
	private String title;
	private String author;
	private int year;
	private int isbn;
	private double price;
	
	public Book() {
		
	}
	
	public Book(String title, String author, int year, int isbn, double price) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}

	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public int getIsbn() {
		return isbn;
	}



	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn
				+ ", price=" + price + "]";
	}

}
