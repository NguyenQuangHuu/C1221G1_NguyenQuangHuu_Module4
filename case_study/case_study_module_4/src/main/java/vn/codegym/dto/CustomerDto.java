package vn.codegym.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.model.CustomerType;
import vn.codegym.utils.RegEx;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;

public class CustomerDto implements Validator {
    private Integer id;
    private String code;
    private String name;

    private String birthday;

    private Integer gender;

    private String card;

    private String phone;
    private String email;
    private String address;

    @NotNull(message = "{notNull}")
    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(String code, String name, String birthday, Integer gender, String card, String phone, String email, String address, CustomerType customerType) {
        this.code = code;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.card = card;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        if(!RegEx.codeCustomerCheck(customerDto.getCode())){
            errors.rejectValue("code","customer.code","nonn");
        }

        if ("".equals(customerDto.getName())){
            errors.rejectValue("name","name.notBlank","nonnn");
        } else if(!RegEx.nameCheck(customerDto.getName())){
            errors.rejectValue("name","name.pattern","nonnn");
        }

        if("".equals(customerDto.getEmail())){
            errors.rejectValue("email","email.notNull","nonnn");
        }else if(!RegEx.emailValidate(customerDto.email)){
            errors.rejectValue("email","email.pattern","nonn");
        }

        if("".equals(customerDto.phone)){
            errors.rejectValue("phone","phone","nonn");
        }else if(!RegEx.phoneNumberValidate(customerDto.phone)){
            errors.rejectValue("phone","phone","nonn");
        }

        if("".equals(customerDto.birthday)){
            errors.rejectValue("birthday","birthday.pattern","nonnn");
        }else if(Period.between(LocalDate.parse(customerDto.birthday),LocalDate.now()).getYears()<18){
            errors.rejectValue("birthday","age","nonn");
        }

        if("".equals(customerDto.card)){
            errors.rejectValue("card","card","nonnn");
        }else if(!RegEx.passportValidate(customerDto.card)){
            errors.rejectValue("card","card","nonnn");
        }

    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof CustomerDto)) return false;
//        CustomerDto that = (CustomerDto) o;
//        return id.equals(that.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }

}
