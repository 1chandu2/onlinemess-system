package com.chandu.onlinemess.api;

import com.chandu.onlinemess.common.enums.APIStatus;
import com.chandu.onlinemess.common.util.ResponseUtil;
import com.chandu.onlinemess.dto.APIResponse;
import com.chandu.onlinemess.dto.ItemDTO;
import com.chandu.onlinemess.entity.Item;
import com.chandu.onlinemess.service.ItemService;
import com.chandu.onlinemess.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/secy/item")
public class ItemController {

   @Autowired private ItemService itemService;
   @Autowired private ResponseUtil responseUtil;

   @RequestMapping(method = RequestMethod.GET, path = "/{id}")
   public ResponseEntity<APIResponse> get(@PathVariable(value = "id", required = false) String itemId) {
      //TODO: NOT REQUIRED RIGHT NOW
      return null;
   }

   @RequestMapping(method = RequestMethod.POST)
   public ResponseEntity<APIResponse> create(@RequestBody ItemDTO itemDTO) {
      itemService.createItem(itemDTO);
      return responseUtil.successResponse(APIStatus.OK);
   }

}
