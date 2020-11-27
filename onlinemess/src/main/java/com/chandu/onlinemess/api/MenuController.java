package com.chandu.onlinemess.api;

import com.chandu.onlinemess.common.enums.APIStatus;
import com.chandu.onlinemess.dto.APIResponse;
import com.chandu.onlinemess.dto.ItemDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/secy/menu")
public class MenuController {

   private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

//   @RequestMapping(method = RequestMethod.POST)
//   public ResponseEntity<APIResponse> create(@RequestBody ItemDTO itemDTO) {
//      itemService.createItem(itemDTO);
//      return responseUtil.successResponse(APIStatus.OK);
//   }
}
