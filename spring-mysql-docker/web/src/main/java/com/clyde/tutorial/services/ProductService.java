package com.clyde.tutorial.services;

import com.clyde.tutorial.dto.Product;
import com.clyde.tutorial.persistence.ProductEntity;
import com.clyde.tutorial.persistence.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProduct(Long id) {
        Optional<ProductEntity> result = productRepository.findById(id);
        return result.isPresent() ? modelMapper.map(result.get(), Product.class) : null;
    }

}
