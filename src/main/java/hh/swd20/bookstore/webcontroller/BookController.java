package hh.swd20.bookstore.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.swd20.bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired	// This wires the repository class in the controller class by injecting the BookRepository class in to the BookContoller class.
	private BookRepository bookRepository;
	
	@RequestMapping("/bookstore")	// Name of the (address) page.
	public String bookstore(Model model) {	// With model the content is pushed from controller to view.
		model.addAttribute("books", bookRepository.findAll()); // Gives and attribute for the model. The attribute has the key word "books", with which the Book list content can be used be the method ".findAll()". 
		return "bookstore";			// Name of the html file, where the controller model content is viewed.
	}

}
