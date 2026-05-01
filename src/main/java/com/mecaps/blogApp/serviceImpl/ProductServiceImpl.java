package com.mecaps.blogApp.serviceImpl;

import com.mecaps.blogApp.Exception.ResourcrsNotFoundException;
import com.mecaps.blogApp.entity.Product;
import com.mecaps.blogApp.repository.ProductRepository;
import com.mecaps.blogApp.requestDTO.ProductRequestDTO;
import com.mecaps.blogApp.responseDTO.ProductResponseDTO;
import com.mecaps.blogApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
@Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDTO create(ProductRequestDTO requestDTO) {
        Product product = new Product();
        product.setName(requestDTO.getName());
        product.setPrice(requestDTO.getPrice());
        product.setQuantity(requestDTO.getQuantity());
        Product save = productRepository.save(product);
        return  new ProductResponseDTO(save);
    }

    @Override
    public ProductResponseDTO update(Long id, ProductRequestDTO requestDTO) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourcrsNotFoundException("Id not found" + id));
        product.setName(requestDTO.getName());
        product.setPrice(requestDTO.getPrice());
        product.setQuantity(requestDTO.getQuantity());
        Product save = productRepository.save(product);
        return new ProductResponseDTO(save);
    }

    @Override
    public List<ProductResponseDTO> getAll() {
        List<Product> all = productRepository.findAll();
        return all.stream().map(ProductResponseDTO::new).toList();
    }

    @Override
    public ProductResponseDTO getByID(Long id) {
       Product product = productRepository.findById(id).orElseThrow(()->new ResourcrsNotFoundException("id not found" + id));
               return new ProductResponseDTO(product);
    }

    @Override
    public String deleted(Long id) {
      Product product = productRepository.findById(id).orElseThrow(() -> new ResourcrsNotFoundException("ID not found" + id));

      productRepository.delete(product);
        return "User deleted successfully";
    }

    @Override
    public List<ProductResponseDTO> findByName(String name) {

      List<Product> findbyname  = productRepository.findByName(name);
      if(findbyname.isEmpty()){
          throw new ResourcrsNotFoundException("product name not found");
      }
      return findbyname.stream().map(ProductResponseDTO::new).toList();
    }

    @Override
    public List<ProductResponseDTO> findByNameAndPrice(String name, Double price) {
        List<Product> findbyname  = productRepository.findByName(name);
        if(findbyname.isEmpty()){
            throw new ResourcrsNotFoundException("product name not found");
        }
        List<Product> findbynameandprice = productRepository.findByNameAndPrice(name,price);
        if(findbynameandprice.isEmpty()){
            throw new ResourcrsNotFoundException("price is invalid found");
        }
        return  findbynameandprice.stream().map(ProductResponseDTO::new).toList();
    }
}

