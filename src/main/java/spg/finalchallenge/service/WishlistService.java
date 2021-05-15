package spg.finalchallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spg.finalchallenge.entity.Client;
import spg.finalchallenge.entity.Wishlist;
import spg.finalchallenge.repository.WishlistRepository;

import java.util.Optional;


@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    public Wishlist add(Wishlist wishlist){
        return wishlistRepository.save(wishlist);
    }

    public Wishlist getId(long id){
        return wishlistRepository.findById(id);
    }

    public Wishlist update(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    public long count(){
        return wishlistRepository.count();
    }

    public Optional<Wishlist> findById(Long id) {
        return wishlistRepository.findById(id);
    }

}
