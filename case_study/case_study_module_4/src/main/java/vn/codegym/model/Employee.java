package vn.codegym.model;


import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Column(columnDefinition = "DATE")
    private String birthday;
    private Integer gender;
    private String card;
    private Double salary;
    private String phone;
    private String email;
    private String address;

    @OneToOne
    @JoinColumn(name="account",referencedColumnName = "username")
    private Account account;


    @ManyToOne
    @JoinColumn(name="education_id",referencedColumnName = "id")
    private Education education;

    @ManyToOne
    @JoinColumn(name="division_id",referencedColumnName = "id")
    private Division division;

    @ManyToOne
    @JoinColumn(name="position_id",referencedColumnName = "id")
    private Position position;

    public Employee() {
    }

    public Employee(String name, String birthday, Integer gender, String card, Double salary, String phone, String email, String address, Education education, Division division, Position position) {
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
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
}
