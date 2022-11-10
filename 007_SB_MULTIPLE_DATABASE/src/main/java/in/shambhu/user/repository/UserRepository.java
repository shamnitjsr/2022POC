package in.shambhu.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.shambhu.model.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
