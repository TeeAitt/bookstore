package hh.swd20.bookstore.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	@Autowired	// This wires the repository class in the controller class by injecting the BookRepository class in to the BookContoller class.
	private CategoryRepository categoryRepository;
	
	//This function prints the categories on the "/categorylist" page.
	@RequestMapping("/categorylist")
	public String categories(Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		model.addAttribute("category", new Category());
		return "categorylist";
	}
		
	// This function prints an empty form for creating a new category.
	@RequestMapping(value = "/newcateg")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "newcategory";
	}
		
	// This function creates the new category and works same way as the save function that saves a book.
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Category category) {
		categoryRepository.save(category);
		return "redirect:categorylist";
	}

}
