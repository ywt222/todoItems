package com.wenting.api.controller;

import com.wenting.api.helper.TestItemRepository;
import com.wenting.api.viewmodel.Items;
import com.wenting.model.Item;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class ListItemsControllerTest {
    private TestItemRepository testItemRepository;
    private ListItemsController listItemsController;
    private Integer id = 1;

    @Before
    public void setUp() throws Exception {
        testItemRepository = new TestItemRepository();
        listItemsController = new ListItemsController(testItemRepository);
    }

    @Test
    public void shouldListAllItems() throws Exception {
        ResponseEntity<Items> response = listItemsController.listAllItems();
        Item sampleItem = response.getBody().getItems().get(0);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Items.class, response.getBody().getClass());

        assertEquals(id, sampleItem.getId());
        assertEquals("sample item text", sampleItem.getText());
        assertEquals(false, sampleItem.getDone());
    }
}
