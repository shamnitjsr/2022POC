package in.shambhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.shambhu.model.User;
import in.shambhu.repository.UserRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/user")
	public ResponseEntity<User>registerUser(@RequestBody User user) {
		System.out.println("Controller Called");
		return ResponseEntity.ok(userRepository.save(user));
		
	}
}
