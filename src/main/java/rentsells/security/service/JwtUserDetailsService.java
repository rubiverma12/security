package rentsells.security.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rentsells.security.model.Login;
import rentsells.security.repository.UserRepository;


@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String input) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername");
		if(input.contains("@")) {
			System.out.println("if loadUserByUsername");
			Login user = userRepository.findByEmail(input)
					.orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + input));
			System.out.println("user=="+user);
			return new User(user.getEmail(),"$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",new ArrayList<>());
		}else {		
			System.out.println("else loadUserByUsername");
			Login user = userRepository.findByMobile(input)
					.orElseThrow(() -> new UsernameNotFoundException("User Not Found with mobile: " + input));
			System.out.println("user=="+user);
			return new User(user.getMobile(),"$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",new ArrayList<>());
		}
	}
	
	/*@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("javainuse".equals(username)) {
			return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}*/
}
