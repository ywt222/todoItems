package com.wenting.api.controller;

import com.wenting.api.helper.TestItemRepository;
import com.wenting.model.Item;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DeleteItemControllerTest {
    private TestItemRepository testItemRepository;
    private DeleteItemController deleteItemController;
    private Integer id = 1;

    @Test
    public void shouldDeleteItemSuccessfully() throws Exception {
        Item item = new Item(1, "first test text", true);

        testItemRepository = new TestItemRepository(item);
        deleteItemController = new DeleteItemController(testItemRepository);
        ResponseEntity<Item> response = deleteItemController.deleteItem(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
    }
}
