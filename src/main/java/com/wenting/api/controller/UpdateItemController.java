package com.wenting.api.controller;

import com.wenting.api.viewmodel.UpdatedItem;
import com.wenting.model.Item;
import com.wenting.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todoitems")
public class UpdateItemController {
    private ItemRepository itemRepository;

    @Autowired
    public UpdateItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> updateItem(@PathVariable("id") Integer id,
                                           @RequestBody UpdatedItem updatedItem) {

        Item item = itemRepository.findById(id);

        if (item == null) {
            return ResponseEntity.notFound().build();
        }

        if (!(updatedItem.getText() instanceof String && updatedItem.getDone() instanceof Boolean)) {
            return ResponseEntity.badRequest().build();
        }

        item.setText(updatedItem.getText());
        item.setDone(updatedItem.getDone());
        itemRepository.save(item);

        Item response = itemRepository.findById(id);

        return new ResponseEntity<Item>(response, HttpStatus.OK);
    }
}
