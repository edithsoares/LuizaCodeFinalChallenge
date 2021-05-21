package spg.finalchallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spg.finalchallenge.entity.Product;
import spg.finalchallenge.entity.Wishlist;
import spg.finalchallenge.repository.WishlistRepository;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    //- Insert um product na Wishlist do client;
    public Wishlist saveWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    // Busca pelo Id da Wishlist
    public Wishlist findByIdWishlist(long id) {
        return wishlistRepository.findById(id);
    }

    public Wishlist findByClientCpf(String cpf) {
        return wishlistRepository.findByClientCpf(cpf);
    }

    public long count() {
        return wishlistRepository.count();
    }

    public void quantity(Wishlist wishlist) {
        long total = 0;
        List<Product> products = wishlist.getProducts();
        total += products.size();
        wishlist.setQuantity(total);
    }

    //    Subtrai o valor do produto removido
    public void subTotal(Wishlist wishlist) {
        BigDecimal total = BigDecimal.ZERO;
        List<Product> listProduct = wishlist.getProducts();
        for (Product product : listProduct) {
            total = wishlist.getTotalPrice().subtract(product.getValue());
        }
        wishlist.setTotalPrice(total);
    }


    // Subtrai o valor total dos produto adionados na lista
    public void sumTotal(Wishlist wishlist) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        List<Product> listProduct = wishlist.getProducts();
        for (Product product : listProduct) {
            totalPrice = totalPrice.add(product.getValue(), new MathContext(5));
        }
        wishlist.setTotalPrice(totalPrice);
    }
}
