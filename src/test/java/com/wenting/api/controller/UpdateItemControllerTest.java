package com.wenting.api.controller;

import com.wenting.api.helper.TestItemRepository;
import com.wenting.api.request.UpdatedItem;
import com.wenting.model.Item;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class UpdateItemControllerTest {
    private TestItemRepository testItemRepository;
    private UpdateItemController updatedController;
    private Integer id = 1;

    @Test
    public void shouldUpdateItemSuccessfully() throws Exception {
        Item item = new Item(1, "first test text", true);

        testItemRepository = new TestItemRepository(item);
        updatedController = new UpdateItemController(testItemRepository);
        ResponseEntity<Item> response = updatedController.updateItem(id, new UpdatedItem());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertSame(item, response.getBody());
    }
}
