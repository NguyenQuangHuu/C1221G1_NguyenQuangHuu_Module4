package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Users;

public interface IUserRepository extends JpaRepository<Users,Long> {
    Users findByUserName(String username);
}
