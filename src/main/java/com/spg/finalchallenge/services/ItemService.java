package com.spg.finalchallenge.services;

import com.spg.finalchallenge.entity.Item;
import com.spg.finalchallenge.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item saveItem(Item item){
        return itemRepository.save(item);
    }

    public Item buscarItem(long id){
        return itemRepository.findById(id);
    }

    public long count(){
        return itemRepository.count();
    }
}
