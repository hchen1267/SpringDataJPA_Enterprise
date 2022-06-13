package com.genpt.springdatajpa.service;

import com.genpt.springdatajpa.entities.Items;
import com.genpt.springdatajpa.repository.ItemRepository;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
@Service
public class ItemService {
    private final ItemRepository itemRepository;
    @Autowired
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }


    public List<Items> findAll(){
        List<Items> itemList = new ArrayList<>();
        Iterable<Items> iterable = itemRepository.findAll(Sort.by("price").descending());
        iterable.forEach(Items -> itemList.add(Items));
        return itemList;
    }

    public List <Items> findAllByIdIn(int[] itemId){
        List<Items> itemList = new ArrayList<>();
        Iterable<Items> iterable = itemRepository.findAllByIdIn(itemId);
        iterable.forEach(Items -> itemList.add(Items));
        return itemList;
    }
}
