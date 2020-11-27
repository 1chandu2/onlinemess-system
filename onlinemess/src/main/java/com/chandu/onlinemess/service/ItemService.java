package com.chandu.onlinemess.service;

import com.chandu.onlinemess.dto.ItemDTO;
import com.chandu.onlinemess.entity.Item;

public interface ItemService {
   public void createItem(ItemDTO itemDTO);

   public Item getItemById();
}
