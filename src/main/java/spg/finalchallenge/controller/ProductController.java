package spg.finalchallenge.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spg.finalchallenge.entity.Product;
import spg.finalchallenge.service.ProductService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public Product addProduto(@RequestBody Product product) {
        return productService.add(product);
    }

    @GetMapping("/product/{id}")
    public Product getId(@PathVariable(value = "id") long id) {
        return productService.getId(id);
    }

    @PutMapping("/produto/{id}")
    public Product updateProduto(@RequestBody Product product, @PathVariable(value = "id") long id) {
        Optional<Product> productResult = productService.findById(id);
        if(productResult.isPresent()){
            product.setId(productResult.get().getId());
            return productService.update(product);
        }
        return null;
    }
}
