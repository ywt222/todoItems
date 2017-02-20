package com.wenting.api.controller;

import com.wenting.api.helper.TestItemRepository;
import com.wenting.api.request.Items;
import com.wenting.model.Item;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class ListItemsControllerTest {
    private TestItemRepository testItemRepository;
    private ListItemsController listItemsController;

    @Test
    public void shouldListAllItems() throws Exception {
        Item item1 = new Item(1, "first test text", true);
        Item item2 = new Item(2, "second test text", false);

        List<Item> items = Arrays.asList(item1, item2);
        testItemRepository = new TestItemRepository(items);
        listItemsController = new ListItemsController(testItemRepository);
        ResponseEntity<Items> response = listItemsController.listAllItems();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertSame(items, response.getBody().getItems());
    }
}
