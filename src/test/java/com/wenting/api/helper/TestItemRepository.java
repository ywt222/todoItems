package com.wenting.api.helper;

import com.wenting.model.Item;
import com.wenting.repository.ItemRepository;

import java.util.Arrays;
import java.util.List;


public class TestItemRepository extends TestJpaRepositoryAdaptor<Item, Integer> implements ItemRepository {

    Item item1 = new Item(1, "first test text", true);
    Item item2 = new Item(2, "second test text", false);

    List<Item> items = Arrays.asList(item1, item2);

    public TestItemRepository(List<Item> items) {
        this.items = items;
    }

    public TestItemRepository(Item item) {
        this.item1 = item;
    }

    @Override
    public Item findById(Integer id) {
        return item1;
    }

    @Override
    public List<Item> findAll() {
        return items;
    }
}
