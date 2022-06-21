package vn.codegym.model;

public interface IOrdersDetail {
    String getOrderId();
    String getProductName();
    String getProductPrice();
    String getTypeProduct();
    String getBuyDate();
    String getOrderQuantity();
    String getOrderTotal();
}
