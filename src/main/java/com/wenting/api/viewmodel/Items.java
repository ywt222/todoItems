package com.wenting.api.viewmodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wenting.model.Item;

import java.util.ArrayList;
import java.util.List;

public class Items {
  @JsonProperty("items")
  private List<Item> items = new ArrayList<Item>();

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }
}
