package spg.finalchallenge.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spg.finalchallenge.entity.Wishlist;
import spg.finalchallenge.service.WishlistService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @PostMapping("/wishlist")
    public Wishlist addWish(@RequestBody Wishlist wishlist) {
        return wishlistService.add(wishlist);
    }

    @GetMapping("/wishlist/{id}")
    public Wishlist getId(@PathVariable(value = "id") long id) {
        return wishlistService.getId(id);
    }

    @PutMapping("/wishlist/{id}")
    public Wishlist update(@RequestBody Wishlist wishlist, @PathVariable(value = "id") long id) {
        Optional<Wishlist> wishlistResult = wishlistService.findById(id);
        if(wishlistResult.isPresent()){
            wishlist.setId(wishlistResult.get().getId());
            return wishlistService.update(wishlist);
        }
        return null;
    }
}
