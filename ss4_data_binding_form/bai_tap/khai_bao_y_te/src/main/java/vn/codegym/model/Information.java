package vn.codegym.model;

public class Information {
    private String name;
    private String dayOfBirth;
    private String gender;
    private String country;
    private String passportId;
    private String vehicles;
    private String vehiclesPlate;
    private String seatNumber;
    private String startDate;
    private String endDate;
    private String description;

    public Information() {
    }

    public Information(String name, String dayOfBirth, String gender, String country, String passportId, String vehicles, String vehiclesPlate, String seatNumber, String startDate, String endDate, String description) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.country = country;
        this.passportId = passportId;
        this.vehicles = vehicles;
        this.vehiclesPlate = vehiclesPlate;
        this.seatNumber = seatNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public String getVehicles() {
        return vehicles;
    }

    public void setVehicles(String vehicles) {
        this.vehicles = vehicles;
    }

    public String getVehiclesPlate() {
        return vehiclesPlate;
    }

    public void setVehiclesPlate(String vehiclesPlate) {
        this.vehiclesPlate = vehiclesPlate;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
