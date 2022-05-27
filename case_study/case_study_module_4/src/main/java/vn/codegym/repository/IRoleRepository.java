package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Role;

public interface IRoleRepository extends JpaRepository<Role,Integer> {
}
