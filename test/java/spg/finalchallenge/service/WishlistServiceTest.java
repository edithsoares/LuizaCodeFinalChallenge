//package spg.finalchallenge.service;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import spg.finalchallenge.entity.Client;
//import spg.finalchallenge.entity.Product;
//import spg.finalchallenge.entity.Wishlist;
//
//import javax.xml.crypto.Data;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class WishlistServiceTest {
//
//    @Autowired
//    WishlistService wishlistServiceTest;
//
//    private List<Product> createProduct(String name, BigDecimal value, String descripion){
//        Product product = new Product();
//        product.setName(name);
//        product.setValue(value);
//        product.setDescription(descripion);
//
//        List<Product> proList  = new ArrayList<>();
//        proList.add(product);
//
//        return proList;
//    }
//
//    private Client creatClient(String name, String cpf){
//        Client client = new Client();
//        client.setName(name);
//        client.setCpf(cpf);
//        return client;
//    }
//
//    private Wishlist instaceWishlist(Client client, List<Product> products){
//        Wishlist wishlist = new Wishlist();
//        wishlist.setClient(client);
//        wishlist.setProducts(products);
//        return wishlist;
//    }
//
//    @Test
//    public void teste(){
//        System.out.println("certooo!!!");
//    }
//}
