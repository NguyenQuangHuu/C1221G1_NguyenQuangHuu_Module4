package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Users;

public interface IUsersRepository extends JpaRepository<Users,String> {
    Users findAccountByUsername(String username);
}
