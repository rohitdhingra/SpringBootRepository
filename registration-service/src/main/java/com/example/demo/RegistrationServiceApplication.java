package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class RegistrationServiceApplication {
	
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/register")
	public String register(@RequestBody User user)
	{
		userRepository.save(user);
		return "Hi"+user.getName()+" your registration process successfully completed";
	}
	
	@GetMapping("/getAllUsers")
	public List<User> findAllUsers()
	{
		return userRepository.findAll();
	}
	
	
	@GetMapping("/findUser/{emailId}")
	public List<User> findUser(@PathVariable String emailId)
	{
		return userRepository.findByEmailId(emailId);
	}
	
	@DeleteMapping("/cancel/{id}")
	public List<User> cancelRegistration(@PathVariable int id)
	{
		userRepository.deleteById(id);
		return userRepository.findAll();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RegistrationServiceApplication.class, args);
	}

}
