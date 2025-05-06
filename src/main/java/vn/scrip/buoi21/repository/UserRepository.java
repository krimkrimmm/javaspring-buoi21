package vn.scrip.buoi21.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.scrip.buoi21.entity.User;
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}