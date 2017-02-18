package com.wenting.api.helper;

import com.wenting.model.Item;
import com.wenting.repository.ItemRepository;

import java.util.Collections;
import java.util.Date;
import java.util.List;


public class TestItemRepository extends TestJpaRepositoryAdaptor<Item, Integer> implements ItemRepository {
    Item sampleItem = createSampleItem(1);

    @Override
    public Item findById(Integer id) {
        return sampleItem;
    }

    @Override
    public List<Item> findAll() {
        return Collections.singletonList(sampleItem);
    }

    private Item createSampleItem(Integer id) {
        Item item = new Item();
        item.setId(id);
        item.setTimestamp(new Date());
        item.setText("sample item text");
        item.setDone(false);
        return item;
    }
}
