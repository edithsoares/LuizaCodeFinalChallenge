package com.spg.finalchallenge.services;

import com.spg.finalchallenge.entity.Product;
import com.spg.finalchallenge.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Product buscarProduto(long id){
        return productRepository.findById(id);
    }

    public long count(){
        return productRepository.count();
    }
}
