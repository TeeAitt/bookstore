package hh.swd20.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity		// Describes the structure of the database table that is corresponding to the class
			// table name, column names and data types, primary key etc. In short: an entity represents a table in relational database.
public class Book {
	@Id		// Sets the primary key. It annotates an attribute to be the primary key. In this the attribute is named id (as well).
	@GeneratedValue(strategy=GenerationType.IDENTITY)  // Automatically generates new primary key values (in this it's the id), when new information is inputed in the table.
	private long id;
	private String title;
	private String author;
	private int year;
	private String isbn;
	private double price;
	
	// JsonIgnore will prevent an infinite loop that will happen with a JSON and OneToMany combination.
	@JsonIgnoreProperties("books")
	@ManyToOne  // This annotation creates a link to another database table, and by that creates a relationship between the tables.
	@JoinColumn(name = "categId")  // This annotation defines the owner of the relationship. In this, it is the Category table and its primary key "id".
	private Category category;  // The type of this attribute is Category, because of the Category object, which is the owner of this relationship.
	
	public Book() {
		
	}
	

	public Book(String title, String author, int year, String isbn, double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}

	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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



	public String getIsbn() {
		return isbn;
	}



	public void setIsbn(String isbn) {
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
		if (this.category != null)
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn
				+ ", price=" + price + " category =" + this.getCategory() + "]";
		else
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn
				+ ", price=" + price + "]";
	}

}
