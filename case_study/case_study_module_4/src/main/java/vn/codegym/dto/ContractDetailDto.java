package vn.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.model.AttachService;
import vn.codegym.model.Contract;
import vn.codegym.utils.RegEx;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

public class ContractDetailDto implements Validator {
    private Integer id;
    private Contract contractId;
    private AttachService attachService;
    private String quantity;

    public ContractDetailDto() {
    }

    public ContractDetailDto(Contract contractId, AttachService attachService, String quantity) {
        this.contractId = contractId;
        this.attachService = attachService;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contract getContractId() {
        return contractId;
    }

    public void setContractId(Contract contract) {
        this.contractId = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContractDetailDto)) return false;
        ContractDetailDto that = (ContractDetailDto) o;
        return id.equals(that.id) &&
                contractId.equals(that.contractId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contractId);
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDetailDto contractDetailDto = (ContractDetailDto) target;
        if(contractDetailDto.getContractId()==null){
            errors.rejectValue("contractId","notNull","non");
        }
        if(contractDetailDto.getAttachService()==null){
            errors.rejectValue("attachService","notNull","non");
        }
        if("".equals(contractDetailDto.getQuantity())){
            errors.rejectValue("quantity","quantity.positive","nonn");
        }else  if(!RegEx.numberPositive(contractDetailDto.quantity)){
            errors.rejectValue("quantity","quantity.positive","nonn");
        }
    }
}
