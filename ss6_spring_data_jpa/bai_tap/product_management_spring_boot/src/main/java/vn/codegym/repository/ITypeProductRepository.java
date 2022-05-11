package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.TypeProduct;

public interface ITypeProductRepository extends JpaRepository<TypeProduct,Integer> {
}
