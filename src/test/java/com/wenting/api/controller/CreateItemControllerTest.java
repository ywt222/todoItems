package com.wenting.api.controller;

import com.wenting.api.helper.TestItemRepository;
import com.wenting.api.request.NewItem;
import com.wenting.model.Item;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CreateItemControllerTest {
    private TestItemRepository testItemRepository;
    private CreateItemController createItemController;

    @Test
    public void shouldCreateItemSuccessfully() throws Exception {
        Item item = new Item(1, "first test text", true);

        testItemRepository = new TestItemRepository(item);
        createItemController = new CreateItemController(testItemRepository);
        ResponseEntity<Item> response = createItemController.createNewItem(new NewItem());

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertSame(item, response.getBody());
    }
}
