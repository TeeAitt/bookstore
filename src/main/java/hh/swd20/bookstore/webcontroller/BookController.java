package hh.swd20.bookstore.webcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.swd20.bookstore.domain.Book;

@Controller
public class BookController {
	
	@GetMapping("/index")
	public String getBooks(Model model) {
		List<Book> books = new ArrayList<Book>();
		model.addAttribute("books", books);
		return "bookstore";
	}

}
