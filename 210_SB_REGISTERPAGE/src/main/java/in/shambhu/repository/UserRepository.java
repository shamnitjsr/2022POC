package in.shambhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.shambhu.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

}
