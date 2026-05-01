package com.mecaps.blogApp.service;

import com.mecaps.blogApp.entity.Product;
import com.mecaps.blogApp.requestDTO.ProductRequestDTO;
import com.mecaps.blogApp.responseDTO.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    ProductResponseDTO create(ProductRequestDTO requestDTO);
    ProductResponseDTO update(Long id, ProductRequestDTO requestDTO);
    List<ProductResponseDTO>getAll();
    ProductResponseDTO getByID(Long id);
    String deleted (Long id);
   // List<ProductResponseDTO> findByProduct_name(String name);
    List<ProductResponseDTO> findByName(String name);
    List<ProductResponseDTO> findByNameAndPrice(String name ,Double price);
    List<ProductResponseDTO> findByQuantity(Integer quantity);
}
