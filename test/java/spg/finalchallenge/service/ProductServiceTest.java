package spg.finalchallenge.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import spg.finalchallenge.entity.Client;
import spg.finalchallenge.entity.Product;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    ProductService productServiceTest;

    private Product instanceProduct(String name, BigDecimal value, String descripion){
        Product product = new Product();
        product.setName(name);
        product.setValue(value);
        product.setDescription(descripion);
        return productServiceTest.saveProduct(product);
    }



    @Test
    public void saveClient(){
        Product product = instanceProduct("Notbook", BigDecimal.valueOf(3400), "Product save in Banck");

        assertThat(product).isNotNull();
    }


    @Test
    public void checkIdClientSave(){
        Product product = instanceProduct("Notbook", BigDecimal.valueOf(3400), "Product save in Banck");

        //Client clientSave = clientServiceTest.saveClient(client);

        assertThat(product.getId()).isEqualTo(1);
    }

    @Test
    public void getClientById(){
        Product product = instanceProduct("Notbook", BigDecimal.valueOf(3400), "Product save in Banck");

        //Client clientSave = clientServiceTest.saveClient(client);

        Product found = productServiceTest.getId(product.getId());

        assertThat(found.getName()).isEqualTo(product.getName());
    }

    @Test
    public void countClient(){
        Product product = instanceProduct("Notbook", BigDecimal.valueOf(3400), "Product save in Banck");//

//        Client clientSvae = clientServiceTest.saveClient(client);

        long qtd = productServiceTest.count();

        assertThat(qtd).isEqualTo(1);
    }
}
