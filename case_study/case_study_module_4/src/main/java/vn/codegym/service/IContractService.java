package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.dto.ContractDto;
import vn.codegym.dto.ICustomerDto;
import vn.codegym.model.AttachService;
import vn.codegym.model.Contract;

import java.util.List;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);

    void add(ContractDto contractDto);

    List<Contract> allContract();

    List<ContractDto> copyList(List<Contract> contracts);

    Page<ICustomerDto> takeEffectService(Pageable pageable);
}
