package vn.codegym.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.dto.ContractDetailDto;
import vn.codegym.model.ContractDetail;
import vn.codegym.repository.IContractDetailRepository;
import vn.codegym.service.IContractDetailService;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository iContractDetailRepository;

    @Override
    public void save(ContractDetailDto contractDetailDto) {
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto,contractDetail);
        contractDetail.setQuantity(Integer.parseInt(contractDetailDto.getQuantity()));
        this.iContractDetailRepository.save(contractDetail);
    }

    @Override
    public List<ContractDetail> findAll() {
        return this.iContractDetailRepository.findAll();
    }
}
