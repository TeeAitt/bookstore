package hh.swd20.bookstore.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore.domain.User;
import hh.swd20.bookstore.domain.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	// This functions prints all users on the userlist page.
	@RequestMapping("/userlist")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String userlist(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "userlist";
	}

/**	
*	Adding and saving a new user is still under develop. The problem is with the password, currently it causes an error in the newuser page.
*	
*	// This function prints an empty form for adding a new user.
*	@RequestMapping("/adduser")
*	@PreAuthorize("hasAuthority('ADMIN')")
*	public String addUser(Model model) {
*		model.addAttribute("user", new User());
*		return "newuser";
*	}
*	
*	// This function saves the new user.
*	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
*	@PreAuthorize("hasAuthority('ADMIN')")
*	public String save(User user) {
*		userRepository.save(user);
*		return "redirect:userlist";
*	}
*
*
**/

/**
*	The delete function is not operating correctly, currently it deletes a book.
*
*	// This function deletes a user.
*	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
*	@PreAuthorize("hasAuthority('ADMIN')")
*	public String deleteUser(@PathVariable(value="id") Long userId) {
*		userRepository.deleteById(userId);
*		return "redirect:../userlist";
*	}
*	
**/

}
