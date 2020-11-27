package com.chandu.onlinemess.service.impl;

import com.chandu.onlinemess.dao.ItemRepository;
import com.chandu.onlinemess.dto.ItemDTO;
import com.chandu.onlinemess.entity.Item;
import com.chandu.onlinemess.mapper.ItemMapper;
import com.chandu.onlinemess.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

   @Autowired
   private ItemRepository itemRepository;
   @Autowired private ItemMapper itemMapper;

   @Override
   public void createItem(ItemDTO itemDTO) {
      Item item = itemMapper.map(itemDTO);
      itemRepository.save(item);
   }

   @Override
   public Item getItemById() {
      return null;
   }
}
