package com.spg.finalchallenge.repository;

import com.spg.finalchallenge.entity.Wishlist;

public interface WishlistRepository {

    Wishlist findById(long id);
    Wishlist save(Wishlist wishlist);
}
