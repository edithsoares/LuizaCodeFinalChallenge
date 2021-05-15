package spg.finalchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spg.finalchallenge.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findById(long id);

    Product save(Product product);

    long count();
}
