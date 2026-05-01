package com.mecaps.blogApp.controller;

import com.mecaps.blogApp.requestDTO.ProductRequestDTO;
import com.mecaps.blogApp.responseDTO.ProductResponseDTO;
import com.mecaps.blogApp.service.ProductService;
import com.mecaps.blogApp.serviceImpl.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Product")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }
    @PostMapping("/create")
    public ProductResponseDTO Create(@Valid @RequestBody ProductRequestDTO productRequestDTO){

        return  productService.create(productRequestDTO);
    }
    @GetMapping("/getall")
    public List<ProductResponseDTO> getall(){
        return  productService.getAll();
    }
    @GetMapping("/getbyid/{id}")
    public  ProductResponseDTO getbyid(@PathVariable Long id){
       ProductResponseDTO productResponseDTO = productService.getByID(id);
       return productResponseDTO;
    }
    @PutMapping("/update/{id}")
    public  ProductResponseDTO updateuser(@PathVariable Long id, @Valid @RequestBody ProductRequestDTO responseDTO){
        return  productService.update(id,responseDTO);
    }
    @GetMapping("/find")
    public  List<ProductResponseDTO> findbyname (@RequestParam String name){
        List<ProductResponseDTO> byProductName = productService.findByName(name);
        return  byProductName;
    }
    @GetMapping("/findn")
    public  List<ProductResponseDTO> findbynameandprice ( @RequestParam String name ,  Double price){
        List<ProductResponseDTO> byNameAndPrice = productService.findByNameAndPrice(name, price);
        return byNameAndPrice;
    }

}
