package spg.finalchallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spg.finalchallenge.entity.Product;
import spg.finalchallenge.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

//  Cadastrar  produto
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

//    Buscar todos os products
    public List<Product> listAllProduct(){
        return productRepository.findAll();
    }

    public Product getId(long idProduct) {
        return productRepository.findById(idProduct);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    public long count() {
        return productRepository.count();
    }
}