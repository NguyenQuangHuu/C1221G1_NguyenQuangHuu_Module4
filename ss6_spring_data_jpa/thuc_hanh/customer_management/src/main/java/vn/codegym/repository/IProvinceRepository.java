package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Province;

public interface IProvinceRepository extends JpaRepository<Province,Integer> {
}
