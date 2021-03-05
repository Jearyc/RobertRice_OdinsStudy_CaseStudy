package com.robertrice.odinsstudy.controllers;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.robertrice.odinsstudy.models.Source;
import com.robertrice.odinsstudy.models.Thesis;
import com.robertrice.odinsstudy.models.User;
import com.robertrice.odinsstudy.relationship.SourceToSourceRelationship;
import com.robertrice.odinsstudy.relationship.ThesisToSourceRelationship;
import com.robertrice.odinsstudy.relationship.ThesisToThesisRelationship;
import com.robertrice.odinsstudy.repository.SourceRepository;
import com.robertrice.odinsstudy.repository.SourceToSourceRepository;
import com.robertrice.odinsstudy.repository.ThesisRepository;
import com.robertrice.odinsstudy.repository.ThesisToSourceRepository;
import com.robertrice.odinsstudy.repository.ThesisToThesisRepository;
import com.robertrice.odinsstudy.repository.UserRepository;

//controller that handles web requests
@Controller
public class HomeController {
	
	private ThesisRepository thesisRepository;
	private SourceRepository sourceRepository;
	private ThesisToSourceRepository TsRepository;
	private ThesisToThesisRepository TtRepository;
	private SourceToSourceRepository SsRepository;
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;
	
	//set up all repositories
	@Autowired
	public HomeController(UserRepository userRepository, PasswordEncoder passwordEncoder,
			ThesisRepository thesisRepository, SourceRepository sourceRepository, ThesisToSourceRepository TsRepository,
			ThesisToThesisRepository TtRepository, SourceToSourceRepository SsRepository) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.thesisRepository = thesisRepository;
		this.sourceRepository = sourceRepository;
		this.TsRepository = TsRepository;
		this.TtRepository = TtRepository;
		this.SsRepository = SsRepository;
	}
	
	//method for supplying all the relevant data from database to home page
	@GetMapping("/")
	public String showHomePage(Model model) {
		model.addAttribute("thesis", new Thesis());
		model.addAttribute("source", new Source());
		
		Iterable<Thesis> allThesis = thesisRepository.findAll();
		Iterable<Source> allSource = sourceRepository.findAll();
		model.addAttribute("allThesis", allThesis);
		model.addAttribute("allSource", allSource);
		return "home";
	}
	//method for supplying login page
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	//method for supplying all the relevant data from database to account page
	//method verifies that users can only access their own account page.
	@GetMapping("/account")
	public String showUserPage(HttpServletRequest request, Model model) {
		String username = request.getUserPrincipal().getName();
		User currentUser = userRepository.findByUsername(username);
		if (!model.containsAttribute("user")) {
			model.addAttribute("user", new User());
		}
		if(!model.containsAttribute("errorMessage")) {
			model.addAttribute("errorMessage", "");
		}
		model.addAttribute("currentUser", currentUser);
		return "account";
	}
	//method for changing user information and saving it to the database
	@PostMapping("/changeUserInfo")
	public String changeUserInfo(@Valid @ModelAttribute("user") User user, BindingResult result, HttpServletRequest request, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "redirect:/account";
		}
		String username = request.getUserPrincipal().getName();
		if(!username.equals(user.getUsername()) && userRepository.findByUsername(user.getUsername()) != null) {
			attr.addFlashAttribute("user", user);
			attr.addFlashAttribute("errorMessage", "Username already in use");
			return "redirect:/account";
		}
		User currentUser = userRepository.findByUsername(username);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		currentUser.setUsername(user.getUsername());
		currentUser.setPassword(user.getPassword());
		currentUser.setEmail(user.getEmail());
		userRepository.save(currentUser);
		
		return "redirect:/account";
	}
	//Method for users to delete all of their data from the database 
	@PostMapping("/deleteUser")
	public String deleteUser(HttpServletRequest request) {
		String username = request.getUserPrincipal().getName();
		User currentUser = userRepository.findByUsername(username);
		userRepository.delete(currentUser);
		return "redirect:/login";
	}
	//method for showing about page
	@GetMapping("/about")
	public String showAboutPage() {
		return "about";
	}
	//method for showing access denied page
	@GetMapping("/accessDenied")
	public String showAccessDeniedPage() {
		return "access_denied";
	}
	//method for showing admin page
	@GetMapping("/admin")
	public String showAdminPage() {
		return "admin";
	}
	//method for displaying that logout was successful
	@GetMapping("/logoutSuccess")
	public String showLogoutPage() {
		return "logout";
	}
	//Method for supplying data from data base to the registration page
	@GetMapping("/register")
	public String showRegistrationPage(Model model) {
		if (!model.containsAttribute("user")) {
			model.addAttribute("user", new User());
		}
		if(!model.containsAttribute("errorMessage")) {
			model.addAttribute("errorMessage", "");
		}
		return "registration";
	}
	//Method for validating user registration and saving valid new user to the database
	@PostMapping("/register")
	public String registerNewUser(@Valid @ModelAttribute("user") User user, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "registration";
		}
		if(userRepository.findByUsername(user.getUsername()) != null) {
			attr.addFlashAttribute("user", user);
			attr.addFlashAttribute("errorMessage", "Username already in use");
			return "redirect:/register";
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		
		
		return "redirect:/login";
	}
	//Method for validating and storing a new thesis
	@PostMapping("/addThesis")
	public String addThesis(@Valid @ModelAttribute("thesis")Thesis thesis, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/";
		}
		thesisRepository.save(thesis);
		return "redirect:/";
	}
	//Method for validating and storing a new source
	@PostMapping("/addSource")
	public String addSource(@Valid @ModelAttribute("source")Source source, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/";
		}
		sourceRepository.save(source);
		return "redirect:/";
	}
	
	//method for showing thesis data to the user and all of the relevant relationships 
	@GetMapping("/thesis")
	public String viewThesis(@RequestParam("id") Long id, Model model, HttpServletRequest request) {
		String username = request.getUserPrincipal().getName();
		User currentUser = userRepository.findByUsername(username);
		Thesis thesis = thesisRepository.findById(id).get();
		Iterable<ThesisToSourceRelationship> tsRelationship = TsRepository.findAllByThesisId(thesis);
		Iterable<ThesisToThesisRelationship> ttRelationship = TtRepository.findAllByThesisIdOneOrThesisIdTwo(thesis,thesis);
		Thesis tempThesis = new Thesis();
		Source tempSource = new Source();
		model.addAttribute("thesis", thesis);
		model.addAttribute("currentUser",currentUser);
		model.addAttribute("tempThesis", tempThesis);
		model.addAttribute("tempSource", tempSource);
		model.addAttribute("tsRelationship", tsRelationship);
		model.addAttribute("ttRelationship", ttRelationship);
		return "thesis";
	}
	//method for showing source data to the user and all of the relevant relationships 
	@GetMapping("/source")
	public String viewSource(@RequestParam("id") Long id, Model model, HttpServletRequest request) {
		String username = request.getUserPrincipal().getName();
		User currentUser = userRepository.findByUsername(username);
		Source source = sourceRepository.findById(id).get();
		Iterable<ThesisToSourceRelationship> tsRelationship = TsRepository.findAllBySourceId(source);
		Iterable<SourceToSourceRelationship> ssRelationship = SsRepository.findAllBySourceIdOneOrSourceIdTwo(source, source);
		Thesis tempThesis = new Thesis();
		Source tempSource = new Source();
		model.addAttribute("source", source);
		model.addAttribute("currentUser",currentUser);
		model.addAttribute("tempThesis", tempThesis);
		model.addAttribute("tempSource", tempSource);
		model.addAttribute("tsRelationship", tsRelationship);
		model.addAttribute("ssRelationship", ssRelationship);
		return "source";
	}
	//method for forming a relationship between thesis
	@PostMapping("/connectThesisToThesis")
	public String connectThesisToThesis(@Valid @ModelAttribute("tempThesis")Thesis tempThesis, BindingResult result) {
		Thesis thesis = new Thesis();
		try {
		thesis = thesisRepository.findById(Long.valueOf(tempThesis.getThesisDescription())).get();
		} catch (NoSuchElementException e) {
			return "redirect:/";
		}
		Thesis connectingThesis = new Thesis();
		try {
		connectingThesis = thesisRepository.findById(tempThesis.getThesisId()).get();
		} catch (NoSuchElementException e) {
			return "redirect:/thesis?id=" + thesis.getThesisId();
		}
		ThesisToThesisRelationship thesisRelationship = new ThesisToThesisRelationship(thesis, connectingThesis);
		TtRepository.save(thesisRelationship);
		return "redirect:/thesis?id=" + thesis.getThesisId();
	}
	//method for forming a relationship between sources
	@PostMapping("/connectSourceToSource")
	public String connectSourceToSource(@Valid @ModelAttribute("tempSource")Source tempSource, BindingResult result) {
		Source source = new Source();
		try {
		source = sourceRepository.findById(Long.valueOf(tempSource.getSourceDescription())).get();
		} catch (NoSuchElementException e) {
			return "redirect:/";
		}
		Source connectingSource = new Source();
		try {
		connectingSource = sourceRepository.findById(tempSource.getSourceId()).get();
		} catch (NoSuchElementException e) {
			return "redirect:/source?id=" + source.getSourceId();
		}
		SourceToSourceRelationship sourceRelationship = new SourceToSourceRelationship(source, connectingSource);
		SsRepository.save(sourceRelationship);
		return "redirect:/source?id=" + source.getSourceId();
	}
	//method for forming a relationship between a thesis and a source
	@PostMapping("/connectThesisToSource")
	public String connectThesisToSource(@Valid @ModelAttribute("tempSource")Source tempSource, BindingResult result) {
		Thesis thesis = new Thesis();
		try {
		thesis = thesisRepository.findById(Long.valueOf(tempSource.getSourceDescription())).get();
		} catch (NoSuchElementException e) {
			return "redirect:/";
		}
		Source connectingSource = new Source();
		try {
		connectingSource = sourceRepository.findById(tempSource.getSourceId()).get();
		} catch (NoSuchElementException e) {
			return "redirect:/thesis?id=" + thesis.getThesisId();
		}
		ThesisToSourceRelationship thesisRelationship = new ThesisToSourceRelationship(thesis, connectingSource);
		TsRepository.save(thesisRelationship);
		return "redirect:/thesis?id=" + thesis.getThesisId();
	}
}
