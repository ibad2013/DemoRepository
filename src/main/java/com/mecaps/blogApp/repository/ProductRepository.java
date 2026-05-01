package com.mecaps.blogApp.repository;

import com.mecaps.blogApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByName(String name);
    List<Product> findByNameAndPrice(String name , Double price);
    List<Product> findByQuantity(Integer quantity);

}
