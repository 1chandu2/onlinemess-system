package com.chandu.onlinemess.api;

import com.chandu.onlinemess.dto.APIResponse;
import com.chandu.onlinemess.common.util.ResponseUtil;
import com.chandu.onlinemess.dto.SignUpRequest;
import com.chandu.onlinemess.common.enums.APIStatus;
import com.chandu.onlinemess.common.exception.ApplicationException;
import com.chandu.onlinemess.entity.User;
import com.chandu.onlinemess.mapper.UserMapper;
import com.chandu.onlinemess.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

   private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

   @Autowired private UserServiceImpl userService;
   @Autowired private UserMapper userMapper;
   @Autowired private ResponseUtil responseUtil;

   @PostMapping("/signup")
   public ResponseEntity<APIResponse> signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
      logger.info("received signup request : {}", signUpRequest);
      if (userService.getByUsername(signUpRequest.getUserName()).isPresent()){
         logger.info("user already exist with userName:{}", signUpRequest.getUserName());
         throw new ApplicationException(APIStatus.USER_ALREADY_EXIST);
      }

      User user = new User();
      userMapper.mapToUser(signUpRequest,user);
      userService.saveUserWithDefaultParams(user);

      return responseUtil.successResponse(APIStatus.OK);
   }
}
