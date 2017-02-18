package com.wenting.api.controller;

import com.wenting.api.helper.TestItemRepository;
import com.wenting.model.Item;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DeleteItemControllerTest {
    private TestItemRepository testItemRepository;
    private DeleteItemController deleteItemController;

    @Before
    public void setUp() throws Exception {
        testItemRepository = new TestItemRepository();
        deleteItemController = new DeleteItemController(testItemRepository);
    }

    @Test
    public void shouldDeleteItemSuccessfully() throws Exception {
        ResponseEntity<Item> response = deleteItemController.deleteItem(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
    }
}
