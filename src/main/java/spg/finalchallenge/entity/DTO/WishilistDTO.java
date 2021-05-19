package spg.finalchallenge.entity.DTO;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import spg.finalchallenge.entity.Client;
import spg.finalchallenge.entity.Product;
import spg.finalchallenge.entity.Wishlist;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class WishilistDTO {


    @Column
    @NotNull
    private Client client;

    @Column
    @NotNull
    private List<Product> products;

    @Column
    @NotNull
    private BigDecimal total;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;

    @Column
    @NotNull
    private long Quantity;

    public WishilistDTO(Wishlist wishlist) {
        this.client = wishlist.getClient();
        this.products = wishlist.getProducts();
        this.total = wishlist.getTotalPrice();
        this.date = wishlist.getDate();
        this.Quantity = wishlist.getQuantity();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static WishilistDTO converter(Wishlist wishlist){
        return new WishilistDTO(wishlist);
    }
}
