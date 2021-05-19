package spg.finalchallenge.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import spg.finalchallenge.entity.Client;
import spg.finalchallenge.entity.Product;
import spg.finalchallenge.entity.Wishlist;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WishlistServiceTest {

    @Autowired
    WishlistService wishlistServiceTest;

    public Wishlist instance (){
        Product prod = new Product();
        prod.setName("12346789015");
        prod.setName("Taina");
        prod.setDescription("");
        prod.setValue(BigDecimal.valueOf(23.00));

        List<Product> products = new ArrayList<>();
        products.add(prod);

        Client cli = new Client();
        cli.setCpf("12346789015");
        cli.setName("Edith");
        cli.setAddress("Rua das flores 98");

        Wishlist wish = new Wishlist();
        wish.setClient(cli);
        wish.setProducts(products);
        wish.setQuantity(10000);
        wish.setTotalPrice(BigDecimal.valueOf(2300000.0));
        return wish;
    }


    @Test
    void salvarWishlistNoBanco() {
        // given

        Wishlist wish = instance();

        // when
        Wishlist wishlistSalva = wishlistServiceTest.saveWishlist(wish);

        // then
        assertThat(wishlistSalva).isNotNull();
    }

    @Test
    void verificarIdDaWishlistSalva() {
        // given

        Wishlist wish = instance();

        // when
        Wishlist wishlistSalva = wishlistServiceTest.saveWishlist(wish);

        // then
        assertThat(wishlistSalva.getId()).isEqualTo(1);
    }

    @Test
    public void getWishlistByID() {
        // given
        Wishlist wish = instance();

        // when
        Wishlist found = wishlistServiceTest.findByIdWishlist(wish.getId());

        // then
        assertThat(found.getId())
                .isEqualTo(wish.getId());
    }

    @Test
    public void contaQuantasWishlistTemNoBanco() {
        // given

        Wishlist wish = instance();

        wishlistServiceTest.saveWishlist(wish);

        // when
        long qtd = wishlistServiceTest.count();

        // then
        assertThat(qtd).isEqualTo(1);
    }
}
