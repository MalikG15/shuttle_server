package lawrence.shuttle.data;

import org.springframework.data.jpa.repository.JpaRepository;
import lawrence.shuttle.to.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByEmailAndPassword(String email, String password);
	public List<User> findAllByRole(String role);
	public User findByEmail(String email);
}
