package com.wenting.api.controller;

import com.wenting.api.helper.TestItemRepository;
import com.wenting.api.viewmodel.NewItem;
import com.wenting.model.Item;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class CreateItemControllerTest {
    private TestItemRepository testItemRepository;
    private CreateItemController createItemController;
    private NewItem request;
    private String newText = "this is new created text";

    @Before
    public void setUp() throws Exception {
        testItemRepository = new TestItemRepository();
        createItemController = new CreateItemController(testItemRepository);
        request = new NewItem();
        request.setText(newText);
    }

    @Test
    public void shouldCreateItemSuccessfully() throws Exception {
        ResponseEntity<Item> response = createItemController.createNewItem(request);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
}
