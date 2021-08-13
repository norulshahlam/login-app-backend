package shah.loginappbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shah.loginappbackend.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	User findByUsername(String username);

}
