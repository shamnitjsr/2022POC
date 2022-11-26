package in.shambhu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.shambhu.model.User;
import in.shambhu.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;

	public User saveUser(User user) {

		return registrationRepository.save(user);
	}

	public User fetchUserByEmailId(String email) {
		return registrationRepository.findByEmailId(email);
	}
	
	public User fetchUserByEmailAndPassword(String email , String password) {
		return registrationRepository.findByEmailIdAndPassword(email , password);
	}

}
