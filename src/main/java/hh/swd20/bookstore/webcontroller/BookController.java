package hh.swd20.bookstore.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired	// This wires the repository class in the controller class by injecting the BookRepository class in to the BookContoller class.
	private BookRepository bookRepository;
	
	
	// This function prints the books on the site
	@RequestMapping("/bookstore")	// Maps this to the "/bookstore" page.
	public String bookstore(Model model) {	// With model the content is pushed from controller to view.
		model.addAttribute("books", bookRepository.findAll()); // Gives an attribute for the model. The attribute has the key word "books", with which the Book list data content can be used with the method ".findAll()", as the BookRepository is the "link" to all the data. 
		return "bookstore";			// Name of the html file, where the controller model content is viewed.
	}
	

	// This function prints an empty form for adding a new book
	@RequestMapping(value = "/add")
    public String addBook(Model model) {
    	model.addAttribute("book", new Book());  // This model attribute uses key word "book", and it creates a new empty Book object.
        return "addbook";
    }
	
	// This function prints existing book information, that can then be edited.
		@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)  // This mapping has a variable, the id inside the curly braces. It refers to the id of particular book object on the web site, so when clicked it will GET information of that id for edit.
	    public String editBook(@PathVariable(value="id") Long bookId, Model model) {  // With PathVariable the particular id is saved in a Long object and also in Model, because for editing it needs to be able to be viewed.
	    	model.addAttribute("book", bookRepository.findById(bookId));  // This model attribute uses key word "book" to find the particular book from BookRepository by its id using ".findById()" method.
			return "editbook";
	    }
	
	
	// This function saves the new book as well edited book information from addBook and editBook functions and POSTs it to the server.
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {	  // This save function uses the new empty Book object, that was created with addBook.
		bookRepository.save(book);	  // Whit the ".save()" method, the new book will be saved in the BookRepository.
		return "redirect:bookstore";  // After save, this redirects back to the bookstore main site.
	}
	
	
	// This function deletes a book
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)  	 // This mapping has a variable, the id inside the curly braces. It refers to the id of particular book object on the web site, so when clicked it will GET information of that id to delete it from the list (and table).
	public String deleteBooks(@PathVariable(value="id") Long bookId) {  // With PathVariable the particular id is saved in a Long object.  
		bookRepository.deleteById(bookId);	// Above the BookRepository was wired to the BookController, so now it can be used with ".deleteById()" method to delete the particular information by using the id which was saved in bookId object.
		return "redirect:../bookstore"; 	// This redirects the end result back to /bookstore page.
	}

}
