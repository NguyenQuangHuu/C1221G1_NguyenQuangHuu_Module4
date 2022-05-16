package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.BorrowBookCode;

public interface IBorrowBookCodeRepository extends JpaRepository<BorrowBookCode,Integer> {

    boolean existsByCode(String code);

    BorrowBookCode findByCode(String code);
}
