package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Position;

public interface IPositionRepository extends JpaRepository<Position , Integer> {
}
