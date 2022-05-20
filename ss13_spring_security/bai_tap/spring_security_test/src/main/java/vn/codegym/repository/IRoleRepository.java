package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.codegym.model.Role;

import java.util.List;

public interface IRoleRepository extends JpaRepository<Role,Long> {

    @Query(value ="select role_name from app_user u inner join user_role r on u.user_id = r.user_id inner join app_role ar on r.role_id = ar.role_id where u.user_id = :id",nativeQuery=true)
    List<String> getRoleName(Long id);

}
