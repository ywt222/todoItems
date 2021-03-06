package com.wenting.repository;

import com.wenting.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    Item findById(Integer id);
}
