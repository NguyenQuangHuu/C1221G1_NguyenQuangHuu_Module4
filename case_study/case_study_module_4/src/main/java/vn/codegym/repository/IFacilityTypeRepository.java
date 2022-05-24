package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.FacilityType;

public interface IFacilityTypeRepository extends JpaRepository<FacilityType,Integer> {
}
