package com.wenting.api.controller;

import com.wenting.api.helper.TestItemRepository;
import com.wenting.api.viewmodel.UpdatedItem;
import com.wenting.model.Item;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class UpdateItemControllerTest {
    private TestItemRepository testItemRepository;
    private UpdateItemController updatedController;
    private UpdatedItem request;
    private Integer id = 1;
    private String updatedText = "this is updated text";
    private Boolean done = true;

    @Before
    public void setUp() throws Exception {
        testItemRepository = new TestItemRepository();
        updatedController = new UpdateItemController(testItemRepository);
        request = new UpdatedItem();
        request.setText(updatedText);
        request.setDone(done);
    }

    @Test
    public void shouldUpdateItemSuccessfully() throws Exception {
        ResponseEntity<Item> response = updatedController.updateItem(1, request);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(id, response.getBody().getId());
        assertEquals(updatedText, response.getBody().getText());
        assertEquals(done, response.getBody().getDone());
    }
}
