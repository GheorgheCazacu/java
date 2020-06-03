package com.clyde.tutorial.services;

import com.clyde.tutorial.dto.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public Product getProduct(Long id) {
        Product result = new Product();
        result.setId(id);
        result.setName("name");
        result.setCategory("category");
        return result;
    }

}
