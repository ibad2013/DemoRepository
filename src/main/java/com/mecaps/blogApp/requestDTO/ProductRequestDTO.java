package com.mecaps.blogApp.requestDTO;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
    /*
    @NotBlank(message =  "Product name should not be blank")
    private String name;
    @NotNull(message = "price should not be empty")
    private double price;
    @Size(min = 1 ,max = 10 , message =  "Quantity should be between 1 -10")
    private  int quantity;

     */
    @NotBlank(message = "Product name should not be blank")
    private String name;

    @NotNull(message = "Price should not be null")
    private Double price;

    @Min(value = 1, message = "Quantity must be at least 1")
    @Max(value = 10, message = "Quantity must be at most 10")
    private Integer quantity;
}
