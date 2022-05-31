package vn.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.model.Customer;
import vn.codegym.model.Employee;
import vn.codegym.model.Facility;
import vn.codegym.utils.RegEx;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class ContractDto implements Validator {
    private Integer id;

    private String startDate;

    private String endDate;

    private String deposit;

    private String totalBill;

    private Employee employee;

    private Customer customer;

    private Facility facility;

    public ContractDto() {
    }

    public ContractDto(String startDate, String endDate, String deposit, String totalBill, Employee employee, Customer customer, Facility facility) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.totalBill = totalBill;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
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

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(String totalBill) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContractDto)) return false;
        ContractDto that = (ContractDto) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        LocalDate now = LocalDate.now();
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if(contractDto.startDate.equals("")){
            errors.rejectValue("startDate","notNull","nonn");
        }else if(Period.between(now,LocalDate.parse(contractDto.startDate)).getDays() < 0){
            errors.rejectValue("startDate","contract.pastDay","nonn");
        };

        if(contractDto.endDate.equals("")){
            errors.rejectValue("endDate","notNull","nonn");
        }else if(Period.between(LocalDate.parse(contractDto.startDate),LocalDate.parse(contractDto.endDate)).getDays()>0 && Period.between(now,LocalDate.parse(contractDto.startDate)).getDays() < 0){
            errors.rejectValue("endDate","contract.diffDay","nôn");
        }else if(Period.between(LocalDate.parse(contractDto.startDate),LocalDate.parse(contractDto.endDate)).getDays() < 0){
            errors.rejectValue("endDate","contract.endDay","nonnn");
        }

        if(contractDto.deposit.equals("")){
            errors.rejectValue("deposit","notNull","nonn");
        }else if(!RegEx.numberTensPositive(contractDto.deposit)){
            errors.rejectValue("deposit","deposit.positive","nonn");
        }

        if(contractDto.totalBill.equals("")){
            errors.rejectValue("totalBill","notNull","nonnn");
        }else if(!RegEx.numberTensPositive(contractDto.totalBill)){
            errors.rejectValue("totalBill","");
        }

        if(contractDto.employee == null){
            errors.rejectValue("employee","notNull","nonnn");
        }
        if(contractDto.customer == null){
            errors.rejectValue("customer","notNull","nonnn");
        }
        if(contractDto.facility == null){
            errors.rejectValue("facility","notNull","nonnn");
        }

//        Xử lý tiền tệ theo đất nước
//        Locale locale = new Locale("vi","VN");
//        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
//        String currency = numberFormat.format(contractDto.deposit);
    }
}
