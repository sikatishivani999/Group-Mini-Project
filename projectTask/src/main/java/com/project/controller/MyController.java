package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.entities.Admin;
import com.project.entities.SkillMatrix;
import com.project.entities.User;
import com.project.repository.SkillRepository;
import com.project.repository.UserRepository;

@Controller
public class MyController {
	@Autowired
	private UserRepository userrepo;
	@Autowired
	private SkillRepository SkillRepo;
	
	
	@GetMapping("/RegistrationForm")
	public String Registration(Model model) {
		model.addAttribute("user",new User());
		return "Reg";
	}
	
	@PostMapping("/process")
	public String createUser(@Valid @ModelAttribute("user")User user, BindingResult result) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	    if(result.hasErrors()) {
			System.out.println(result);
			return "Reg";
		}
	
		userrepo.save(user);
		return "success";
	}
	
	@GetMapping("/Login")
	public String showLogin(User user) {
		System.out.println("shivani");
		return "login";
	}
	
	@GetMapping("/home")
	public String HomePage() {
		return "home";
	}
	
	
	@GetMapping("/skillmatrix")
	public String Skill(HttpServletRequest request, Model model) {
		model.addAttribute("skill", new SkillMatrix());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		System.out.println(currentUserName);
		User user = userrepo.findByEmail(currentUserName);
		System.out.println(user);
		String test = user.getRole();
		System.out.println(test);
		if (test.equalsIgnoreCase("Admin")) {
			return "admin";
		} else {
			return "skillmatrix";
		}
	}
	
	/*
	 * public void EnrolledUserProject() { Authentication authentication =
	 * SecurityContextHolder.getContext().getAuthentication(); String ProjectName =
	 * authentication.getProject(); List<SkillMatrix> enrolledUser =
	 * SkillRepo.findByProject(ProjectName); }
	 */


	@PostMapping("/process1")
	public String enrollProject(@Valid @ModelAttribute("skill")SkillMatrix skill) {
		SkillRepo.save(skill);
		return "welcome";
	}
	/*@GetMapping("/project")
	public String project(HttpServletRequest request, Model model) {
		model.addAttribute("admin", new Admin());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentProject = authentication.
		System.out.println(currentProject);
		SkillMatrix skill = SkillRepo.findByProject(currentProject);
		System.out.println(skill);
		String check = skill.getProject();
		System.out.println(check);
		if (check.equalsIgnoreCase("BRH")) {
			return "admin";
		} else {
			return "BAck";
		}*/
		
	}
	

