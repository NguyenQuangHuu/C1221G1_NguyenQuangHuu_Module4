package vn.codegym.model;
// id, tên sản phẩm, giá sản phẩm, mô tả của sản phẩm, nhà sản xuất.


import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String name;
    private Double price;
    private String description;
    private String manufacturer;
    @ManyToOne
    @JoinColumn(name="type_id",referencedColumnName = "id")
    private TypeProduct product;


    public Product(Integer id, String code, String name, Double price, String description, String manufacturer, TypeProduct product) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.description = description;
        this.manufacturer = manufacturer;
        this.product = product;
    }

    public Product() {

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
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
