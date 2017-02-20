package com.wenting.api.controller;

import com.wenting.api.request.NewItem;
import com.wenting.model.Item;
import com.wenting.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todoitems")
public class CreateItemController {
    private ItemRepository itemRepository;

    @Autowired
    public CreateItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> createNewItem(@RequestBody NewItem newItem) {
        Item item = new Item();

        item.setText(newItem.getText());
        item.setDone(false);
        itemRepository.save(item);

        Item response = itemRepository.findById(item.getId());

        return new ResponseEntity<Item>(response, HttpStatus.CREATED);
    }
}
