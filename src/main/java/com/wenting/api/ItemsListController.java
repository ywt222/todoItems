package com.wenting.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ItemsListController {
@RequestMapping(path = "/todoitems", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public String getItems() {
        return "hello";
    }


}
