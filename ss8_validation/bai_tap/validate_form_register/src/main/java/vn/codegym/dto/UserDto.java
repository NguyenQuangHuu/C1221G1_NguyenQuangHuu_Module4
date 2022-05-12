package vn.codegym.dto;

import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class UserDto implements Validator {
    private int id;

    @Pattern(regexp = "^([a-z]|[A-Z])*$",message="* Không được chứa số")
    private String firstName;
    @Pattern(regexp = "^([a-z]|[A-Z])*$",message="* Không được chứa số")
    private String lastName;

    @Pattern(regexp = "^0\\d{9}$",message = "* Không đúng định dạng số điện thoại")
    private String phoneNumber;


    private String age;

    @NotBlank(message = "{email.check}")
    @Email(message = "{email.check}")
    private String email;

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, String phoneNumber, String age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        EmailValidator emailValidator = EmailValidator.get
        UserDto userDto = (UserDto) target;
        if("".equals(userDto.getFirstName())){
            errors.rejectValue("firstName","firstName.notBlank","NONNN");
        }
        else
        if(userDto.getFirstName().length()<5 || userDto.getFirstName().length()>45 ){
            errors.rejectValue("firstName","firstName.length","nôn");
        }



        if (!userDto.getAge().equals("")) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate birthday = LocalDate.parse(userDto.getAge(),dateTimeFormatter);
            LocalDate now = LocalDate.now();
            if(Period.between(birthday,now).getYears() < 18){
                errors.rejectValue("age","age.check","Nonnn");
            }
        }else {
            errors.rejectValue("age","age.checkNull","nonnn");
        }

        if(userDto.getPhoneNumber().length() != 10){
            errors.rejectValue("phoneNumber","phone.check","nonn");
        }
//
        if("".equals(userDto.getLastName())){
            errors.rejectValue("lastName","lastName.notBlank","nonnn");
        }else
        if(userDto.getLastName().length()<5 || userDto.getLastName().length()>45){
            errors.rejectValue("lastName","lastName.length","nôn");
        }

    }
}
