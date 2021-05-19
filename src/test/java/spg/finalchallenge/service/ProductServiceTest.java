package spg.finalchallenge.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import spg.finalchallenge.entity.Product;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductServiceTest {
    @Autowired
    ProductService productService;

    @Test
    void salvarProductNoBanco() {
        // given
        Product prod = new Product();
        prod.setName("Notebook Samsung Book X40 Intel Core i5 8GB 1TB");
        prod.setName("Taina");
        prod.setDescription("O Notebook Samsung Book X40 foi desenvolvido para " +
                "trazer até você o melhor da tecnologia em uma máquina completa e " +
                "com recursos para atender todas as suas necessidades. Sua configuração " +
                "poderosa conta com processador Intel Core i5 e 8GB de memória RAM, " +
                "garantindo o máximo de desempenho, eficiência e velocidade no uso diário");
        prod.setValue(BigDecimal.valueOf(23.000));

        // when
        Product productSalvo = productService.saveProduct(prod);

        // then
        assertThat(productSalvo).isNotNull();
    }


    @Test
    void verificarIdDoProductSalvo() {
        // given
        Product prod = new Product();
        prod.setName("Notebook Samsung Book X40 Intel Core i5 8GB 1TB");
        prod.setName("Taina");
        prod.setDescription("O Notebook Samsung Book X40 foi desenvolvido para " +
                "trazer até você o melhor da tecnologia em uma máquina completa e " +
                "com recursos para atender todas as suas necessidades. Sua configuração " +
                "poderosa conta com processador Intel Core i5 e 8GB de memória RAM, " +
                "garantindo o máximo de desempenho, eficiência e velocidade no uso diário");
        prod.setValue(BigDecimal.valueOf(23.000));

        // when
        Product productSalvo = productService.saveProduct(prod);

        // then
        assertThat(productSalvo.getId()).isEqualTo(1);
    }

    @Test
    public void getProductByID() {
        // given
        Product prod = new Product();
        prod.setName("Notebook Samsung Book X40 Intel Core i5 8GB 1TB");
        prod.setName("Taina");
        prod.setDescription("O Notebook Samsung Book X40 foi desenvolvido para " +
                "trazer até você o melhor da tecnologia em uma máquina completa e " +
                "com recursos para atender todas as suas necessidades. Sua configuração " +
                "poderosa conta com processador Intel Core i5 e 8GB de memória RAM, " +
                "garantindo o máximo de desempenho, eficiência e velocidade no uso diário");
        prod.setValue(BigDecimal.valueOf(23.000));

        productService.saveProduct(prod);

        // when
        Product found = productService.getId(prod.getId());

        // then
        assertThat(found.getName())
                .isEqualTo(prod.getName());
    }

    @Test
    public void contaQuantosClientesNoBanco() {
        // given
        Product prod = new Product();
        prod.setName("Notebook Samsung Book X40 Intel Core i5 8GB 1TB");
        prod.setName("Taina");
        prod.setDescription("O Notebook Samsung Book X40 foi desenvolvido para " +
                "trazer até você o melhor da tecnologia em uma máquina completa e " +
                "com recursos para atender todas as suas necessidades. Sua configuração " +
                "poderosa conta com processador Intel Core i5 e 8GB de memória RAM, " +
                "garantindo o máximo de desempenho, eficiência e velocidade no uso diário");
        prod.setValue(BigDecimal.valueOf(23.000));

        productService.saveProduct(prod);

        // when
        long qtd = productService.count();

        // then
        assertThat(qtd).isEqualTo(1);
    }
}
