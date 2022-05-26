package vn.codegym.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.dto.ContractDto;
import vn.codegym.dto.ICustomerDto;
import vn.codegym.model.AttachService;
import vn.codegym.model.Contract;
import vn.codegym.repository.IContractRepository;
import vn.codegym.service.IContractService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return this.iContractRepository.findAll(pageable);
    }

    @Override
    public void add(ContractDto contractDto) {
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        contract.setDeposit(Double.parseDouble(contractDto.getDeposit()));
        contract.setTotalBill(Double.parseDouble(contractDto.getTotalBill()));
        this.iContractRepository.save(contract);
    }

    @Override
    public List<Contract> allContract() {
        return this.iContractRepository.findAll();
    }


    @Override
    public List<ContractDto> copyList(List<Contract> contracts) {
        List<ContractDto> contractDto = new ArrayList<>();
        for (Contract contract:
             contracts) {
            ContractDto con = new ContractDto();
            BeanUtils.copyProperties(contract,con);
            con.setDeposit(contract.getDeposit().toString());
            con.setTotalBill(contract.getTotalBill().toString());
            contractDto.add(con);
        }
        return contractDto;
    }

    @Override
    public Page<ICustomerDto> takeEffectService(Pageable pageable) {
        return this.iContractRepository.takeEffectContract(pageable);
    }

}
