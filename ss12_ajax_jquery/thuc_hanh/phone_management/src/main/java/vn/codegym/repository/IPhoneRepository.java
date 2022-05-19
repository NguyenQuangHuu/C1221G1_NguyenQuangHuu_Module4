package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Phone;

public interface IPhoneRepository extends JpaRepository<Phone,Long> {
}
