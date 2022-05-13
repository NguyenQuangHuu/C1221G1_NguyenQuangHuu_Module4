package vn.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import vn.codegym.model.TypeProduct;

import java.text.NumberFormat;


public class ProductDto implements Validator {
    private Integer id;
    private String code;
    private String name;


    private Double price;
    private String description;
    private String manufacturer;
    private TypeProduct product;

    public ProductDto() {

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public TypeProduct getProduct() {
        return product;
    }

    public void setProduct(TypeProduct product) {
        this.product = product;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"manufacturer","notBlank");
        ValidationUtils.rejectIfEmpty(errors,"description","notBlank");
        ValidationUtils.rejectIfEmpty(errors,"name","notBlank");
        ProductDto dto = (ProductDto) target;

            if (dto.getPrice() == null) {
                errors.rejectValue("price", "priceNull", "non");
            }else
            if (!dto.getPrice().toString().matches("[+]?\\d*\\.?\\d*")) {
                errors.rejectValue("price", "priceNaN", "onnnn");
            }else
            if (dto.getPrice() < 0) {
                errors.rejectValue("price", "pricePositive", "onnnnn");
            }

    }
}