package in.shambhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.shambhu.model.User;
import in.shambhu.service.RegistrationService;

@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@PostMapping("/registerUser")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {

		String tempEmailId = user.getEmailId();
		if (tempEmailId != null && !"".equals(tempEmailId)) {
			User userObj = registrationService.fetchUserByEmailId(tempEmailId);
			if (userObj != null)
				throw new Exception("User With " + tempEmailId + " is already exit");
		}
		User userObject = null;

		userObject = registrationService.saveUser(user);

		return userObject;

	}

	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailid = user.getEmailId();
		String tempPassword = user.getPassword();
		User userObj = null;
		if(tempEmailid != null && tempPassword != null ) {
			userObj = registrationService.fetchUserByEmailAndPassword(tempEmailid ,tempPassword );
			return userObj;
		}
		if(userObj != null) {
			throw new Exception("Bad Credentials");
		}
		return userObj;
	}

}
