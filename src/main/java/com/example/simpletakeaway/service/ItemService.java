package com.example.simpletakeaway.service;

import com.example.simpletakeaway.model.Item;
import com.example.simpletakeaway.repo.IItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    IItemRepo repo;

    public List<Item> getAllItems() {
        return new ArrayList<>(repo.findAll());
    }

    public Item getItemById(int id) {
        return repo.findById(id).get();
    }

    public boolean updateItem(int id) {
        Item item = getItemById(id);
        item.setItem_name("item_name");

        return saveOrUpdateItem(item);
    }

    public boolean saveOrUpdateItem(Item item) {
        Item updatedItemObj =  repo.save(item);

        if (getItemById(updatedItemObj.getIditem()) != null) {
            return true;
        }

        return false;
    }

    public boolean deleteItem(int id) {
        repo.deleteById(id);

        if (repo.findById(id) == null) {
            return true;
        }

        return false;
    }
}
