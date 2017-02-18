package com.wenting.api.controller;

import com.wenting.api.viewmodel.Items;
import com.wenting.model.Item;
import com.wenting.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todoitems")
public class ListItemsController {
    private ItemRepository itemRepository;

    @Autowired
    public ListItemsController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Items> listAllItems() {
        Items response = new Items();
        List<Item> items = itemRepository.findAll();
        response.setItems(items);

        return new ResponseEntity<Items>(response, HttpStatus.OK);
    }
}
