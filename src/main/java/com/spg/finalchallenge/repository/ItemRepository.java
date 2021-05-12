package com.spg.finalchallenge.repository;

import com.spg.finalchallenge.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findById(long id);
    Item save(Item item);
    long count();
}
