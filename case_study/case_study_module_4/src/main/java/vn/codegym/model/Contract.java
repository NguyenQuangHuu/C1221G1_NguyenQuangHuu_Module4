package vn.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "DATE")
    private String startDate;

    @Column(columnDefinition = "DATE")
    private String endDate;

    private Double deposit;

    private Double totalBill;

    @ManyToOne
    @JoinColumn(name="employee",referencedColumnName = "id")
    private Employee employee;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="customer",referencedColumnName = "id")
    @JsonBackReference
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="facility",referencedColumnName = "id")
    private Facility facility;

    @OneToMany(mappedBy = "contractId",cascade = CascadeType.ALL)
    private List<ContractDetail> contractDetail;

    public Contract() {
    }

    public Contract(String startDate, String endDate, Double deposit, Double totalBill, Employee employee, Customer customer, Facility facility) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.totalBill = totalBill;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
    }

    public List<ContractDetail> getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(List<ContractDetail> contractDetail) {
        this.contractDetail = contractDetail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(Double totalBill) {
        this.totalBill = totalBill;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}
