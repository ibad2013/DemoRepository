package com.mecaps.blogApp.responseDTO;

import com.mecaps.blogApp.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private String name;
    private double price;
    private int quantity;

    public ProductResponseDTO(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
    }
}

