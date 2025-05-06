package vn.scrip.buoi21.repository;

import vn.scrip.buoi21.entity.User;
import vn.scrip.buoi21.model.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByRole(UserRole userRole);
}