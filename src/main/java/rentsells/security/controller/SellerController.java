package rentsells.security.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rentsells.security.model.Login;
import rentsells.security.repository.UserRepository;

@RestController
@RequestMapping("/admin/v1")
public class SellerController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/createUser")
	public Login createUser(@Valid @RequestBody Login login) {
		return userRepository.save(login);
	}
	
	@GetMapping("/user")
	public List<Login> getAllUser() {
		return userRepository.findAll();
	}
}
