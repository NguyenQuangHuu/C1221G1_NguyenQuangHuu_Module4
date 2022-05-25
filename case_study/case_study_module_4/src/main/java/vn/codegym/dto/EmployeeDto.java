package vn.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.model.Account;
import vn.codegym.model.Division;
import vn.codegym.model.Education;
import vn.codegym.model.Position;
import vn.codegym.utils.RegEx;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.time.Period;

public class EmployeeDto implements Validator {
    private Integer id;
    private String code;
    private String name;
    private String birthday;
    private Integer gender;
    private String card;
    private String salary;
    private String phone;
    private String email;
    private String address;
    private Education education;
    private Division division;
    private Position position;


    public EmployeeDto() {
    }

    public EmployeeDto(String code, String name, String birthday, Integer gender, String card, String salary, String phone, String email, String address, Education education, Division division, Position position) {
        this.code = code;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.card = card;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.education = education;
        this.division = division;
        this.position = position;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
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

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        if("".equals(employeeDto.name)){
            errors.rejectValue("name","name.notBlank","non");
        }
        if("".equals(employeeDto.code)){
            errors.rejectValue("code","notNull","non");
        }

        if("".equals(employeeDto.email)){
            errors.rejectValue("email","email.notNull","nonnn");
        }else if(!RegEx.emailValidate(employeeDto.email)){
            errors.rejectValue("email","email.pattern","nonn");
        }

        if("".equals(employeeDto.phone)){
            errors.rejectValue("phone","phone","nonn");
        }else if(!RegEx.phoneNumberValidate(employeeDto.phone)){
            errors.rejectValue("phone","phone","nonn");
        }

        if("".equals(employeeDto.birthday)){
            errors.rejectValue("birthday","birthday.pattern","nonnn");
        }else if(Period.between(LocalDate.parse(employeeDto.birthday),LocalDate.now()).getYears()<18){
            errors.rejectValue("birthday","age","nonn");
        }

        if("".equals(employeeDto.card)){
            errors.rejectValue("card","card","nonnn");
        }else if(!RegEx.passportValidate(employeeDto.card)){
            errors.rejectValue("card","card","nonnn");
        }

        if("".equals(employeeDto.address)){
            errors.rejectValue("address","address","non");
        }
        if("".equals(employeeDto.salary)){
            errors.rejectValue("salary","notNull","non");
        }else if(!RegEx.numberTensPositive(employeeDto.salary)){
            errors.rejectValue("salary","salary.notNull","nonn");
        }
        if(employeeDto.gender == null){
            errors.rejectValue("gender","notNull","non");
        }
        if(employeeDto.division == null){
            errors.rejectValue("division","notNull","non");
        }
        if(employeeDto.position == null){
            errors.rejectValue("position","notNull","non");
        }
        if(employeeDto.education == null){
            errors.rejectValue("education","notNull","non");
        }
    }
}
