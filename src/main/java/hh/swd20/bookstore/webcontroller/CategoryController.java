package hh.swd20.bookstore.webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	// This function is a RESTful service that will get all the books
	@RequestMapping(value="/categories", method = RequestMethod.GET)
	public @ResponseBody List<Category> getCategoryRest() {  // Java written category object will be transfered to JSON categorylist and returned to the browser with GET method. 
		return (List<Category>) categoryRepository.findAll();
	}
	
	// This function is a RESTful service that will get a category by its id
	@RequestMapping(value="/categories/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Category> findCategoryRest(@PathVariable("id") Long categId) {  // Search a category by its id and if found, then Optional<> is true and the Java written category object will be transfered to JSON and returned with GET method.
		return categoryRepository.findById(categId);
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
	
	// This function is a RESTful service that will save a new category
	@RequestMapping(value="/categories", method = RequestMethod.POST)
	public @ResponseBody Category saveBookRest(@RequestBody Category category) {
		return categoryRepository.save(category);
	}

}


