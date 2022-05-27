package vn.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.model.FacilityType;
import vn.codegym.model.RentType;
import vn.codegym.utils.RegEx;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class FacilityDto implements Validator {
    private Integer id;
    private String code;
    private String name;
    private String area;
    private String cost;
    private String maxPeople;
    private String standardRoom;
    private String descriptionConvenience;
    private String poolArea;
    private String floors;
    private FacilityType facilityType;
    private RentType rentType;

    public FacilityDto() {
    }

    public FacilityDto(String code, String name, String area, String cost, String maxPeople, String standardRoom, String descriptionConvenience, String poolArea, String floors, FacilityType facilityType, RentType rentType) {
        this.code = code;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionConvenience = descriptionConvenience;
        this.poolArea = poolArea;
        this.floors = floors;
        this.facilityType = facilityType;
        this.rentType = rentType;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionConvenience() {
        return descriptionConvenience;
    }

    public void setDescriptionConvenience(String descriptionConvenience) {
        this.descriptionConvenience = descriptionConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getFloors() {
        return floors;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;
        if(facilityDto.floors == null){
            facilityDto.setFloors("0");
        }
        if(!RegEx.serviceCode(facilityDto.code)){
            errors.rejectValue("code","facility.code","non");
        }

        if(!RegEx.numberTensPositive(facilityDto.area)){
            errors.rejectValue("area","area.positive","non");
        }

        if(!RegEx.numberPositive(facilityDto.floors)){
            errors.rejectValue("floors","floors.positive","non");
        }

        if(!RegEx.numberPositive(facilityDto.maxPeople)){
            errors.rejectValue("maxPeople","max.people","nonn");
        }

        if(!RegEx.numberTensPositive(facilityDto.poolArea)){
            errors.rejectValue("poolArea","pool.positive","nonn");
        }
        if(facilityDto.facilityType == null){
            errors.rejectValue("facilityType","notNull","nonn");
        }

        if(facilityDto.rentType == null){
            errors.rejectValue("rentType","notNull","nonn");
        }

        if(facilityDto.standardRoom == null){
            errors.rejectValue("standardRoom","notNull","nonn");
        }
    }
}
