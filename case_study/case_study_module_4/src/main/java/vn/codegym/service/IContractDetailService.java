package vn.codegym.service;

import vn.codegym.dto.ContractDetailDto;
import vn.codegym.model.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    void save(ContractDetailDto contractDetailDto);

    List<ContractDetail> findAll();
}
