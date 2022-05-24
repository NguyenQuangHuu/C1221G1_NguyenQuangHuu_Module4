package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.RentType;

public interface IRentTypeRepository extends JpaRepository<RentType,Integer> {
}
