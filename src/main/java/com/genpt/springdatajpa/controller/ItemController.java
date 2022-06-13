package com.genpt.springdatajpa.controller;


import com.genpt.springdatajpa.entities.Items;
import com.genpt.springdatajpa.repository.ItemRepository;
import com.genpt.springdatajpa.service.ItemService;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.util.Collection;

@RestController
public class ItemController {
    @Autowired
    ItemService itemService;


    @GetMapping(path = "/itemlookup", produces="application/json")
    List<Items> queryGivenItems(@RequestParam(value = "itemid",required = false) int[] itemId){
        if(itemId==null || itemId.length == 0){
            return itemService.findAll();
        }
        else{
            return itemService.findAllByIdIn(itemId);
        }
    }
}


