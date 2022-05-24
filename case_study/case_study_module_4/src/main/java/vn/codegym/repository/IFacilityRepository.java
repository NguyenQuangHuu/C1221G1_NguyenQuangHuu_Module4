package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Facility;

public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
}
