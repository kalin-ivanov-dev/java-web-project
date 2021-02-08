package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.exmaple.demo.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	@Autowired
	private UserService userService;

	
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	@GetMapping()
	public String showRegistrationForm()
	{
		return "registration";
	}
	
	@PostMapping()
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto,BindingResult result)
	{
		User existing = userService.findByEmail(registrationDto.getEmail());
		if(existing != null)
		{
			result.rejectValue("email", null,"There is already an account registered with that email");
		}
		
		if(result.hasErrors())
		{
			return "registration";
		}
		userService.save(registrationDto);
		return "redirect:registration?success";
	}
}
