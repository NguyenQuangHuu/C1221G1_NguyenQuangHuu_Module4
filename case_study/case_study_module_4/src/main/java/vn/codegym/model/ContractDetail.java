package vn.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contract_id",referencedColumnName = "id")
    @JsonBackReference
    private Contract contractId;

    @ManyToOne
    @JoinColumn(name="attach_service_id",referencedColumnName = "id")

    private AttachService attachService;

    private Integer quantity;

    public ContractDetail() {
    }

    public ContractDetail(Contract contractId, AttachService attachService, Integer quantity) {
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

    public void setContractId(Contract contractId) {
        this.contractId = contractId;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}
