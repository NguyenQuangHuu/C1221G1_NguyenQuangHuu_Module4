package com.example.dto;

import com.example.model.Product;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CartDto {
    private Map<ProductDto,Integer> products = new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<ProductDto,Integer> products) {
        this.products = products;
    }

    public Map<ProductDto,Integer> getProducts() {
        return products;
    }

    private boolean checkItemInCart(ProductDto product){
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())){
                return true;
            }
        }
        return false;
    }

    private Map.Entry<ProductDto, Integer> selectItemInCart(ProductDto product){
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())){
                return entry;
            }
        }
        return null;
    }

    public void addProduct(ProductDto product){
        if (!checkItemInCart(product)){
            products.put(product,1);
        } else {
            Map.Entry<ProductDto, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(),newQuantity);
        }
    }

    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity(){
        return products.size();
    }

    public String countTotalPayment(){
        Locale locale = new Locale("vi","vn");
        NumberFormat nf = NumberFormat.getInstance(locale);

        float payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }

        return nf.format(payment);
    }


    public void removeProduct(ProductDto productDto){
        if(products.containsKey(productDto)){

            Integer currentValue = products.get(productDto);
            if(currentValue>1){
                products.put(productDto,currentValue-1);

            }else{
                products.remove(productDto);
            }
        }
    }
}
