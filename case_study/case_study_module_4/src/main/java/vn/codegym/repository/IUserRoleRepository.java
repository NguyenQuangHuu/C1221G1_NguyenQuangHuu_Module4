package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Users;
import vn.codegym.model.UserRole;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole,String> {
    List<UserRole> findUserRoleByUsers_Username(String users);
}
