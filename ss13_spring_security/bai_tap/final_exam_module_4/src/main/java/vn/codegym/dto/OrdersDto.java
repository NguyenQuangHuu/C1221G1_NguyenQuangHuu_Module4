package vn.codegym.dto;

import vn.codegym.model.Product;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class OrdersDto {
    private Integer id;
    private String buyDate;
    private String quantity;
    private Product product;

    public OrdersDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public OrdersDto(String buyDate, String quantity, Product product) {
        this.buyDate = buyDate;
        this.quantity = quantity;
        this.product = product;
    }
}
