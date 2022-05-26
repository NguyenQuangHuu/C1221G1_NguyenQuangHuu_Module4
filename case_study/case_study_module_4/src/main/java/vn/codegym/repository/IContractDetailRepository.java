package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.ContractDetail;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
}
