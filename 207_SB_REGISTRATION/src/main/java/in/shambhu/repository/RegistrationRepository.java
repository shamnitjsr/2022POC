package in.shambhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.shambhu.model.User;

@Repository
public interface RegistrationRepository extends JpaRepository<User, Integer>{

	public User findByEmailId(String email);
	
	public User findByEmailIdAndPassword(String email , String password);
}
