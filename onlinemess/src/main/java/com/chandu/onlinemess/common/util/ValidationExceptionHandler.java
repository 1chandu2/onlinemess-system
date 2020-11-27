package com.chandu.onlinemess.common.util;

import com.chandu.onlinemess.common.enums.APIStatus;
import com.chandu.onlinemess.common.exception.ApplicationException;
import com.chandu.onlinemess.common.exception.JwtExpiredTokenException;
import com.chandu.onlinemess.dto.APIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private ResponseUtil responseUtil;

    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = ApplicationException.class)
    public ResponseEntity<APIResponse> handleApplicationException(ApplicationException ex, WebRequest request) {

        LOGGER.debug("handleApplicationException", ex);

        ResponseEntity<APIResponse> response;
        if (ex.getApiStatus() != APIStatus.OK) {
            response = responseUtil.badRequestResponse(ex.getApiStatus(),ex.getData(),ex.getHttpStatus());
        } else {
            response = responseUtil.buildResponse(ex.getApiStatus(), ex.getData(), HttpStatus.OK);
        }
        return response;
    }

   @ExceptionHandler({RuntimeException.class})
   public @ResponseBody ResponseEntity<APIResponse> handleIllegalArgumentException(Exception e) {
      logger.error("BadRequestException :: ", e);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new APIResponse<>(APIStatus.REQUEST_PAYLOAD_MISSIONG_OR_INVALID, Constant.ParamError.WRONG_INPUT_PARAMETER));
   }

   @ExceptionHandler(value = JwtExpiredTokenException.class)
    public ResponseEntity<APIResponse> handleJwtExpiredTokenException(JwtExpiredTokenException ex, WebRequest request){
       return responseUtil.badRequestResponse(APIStatus.ERR_UNAUTHORIZED,null,HttpStatus.UNAUTHORIZED);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
                                                                          HttpHeaders headers, HttpStatus status, WebRequest request) {

        return new ResponseEntity(new APIResponse<>(APIStatus.ERR_BAD_REQUEST, null), headers, status);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<APIResponse> handleUncatchException(Exception ex, WebRequest request) {

        LOGGER.error("handleUncatchException", ex);
        return responseUtil.buildResponse(APIStatus.ERR_INTERNAL_SERVER, "Please contact System Admin to resolve problem", HttpStatus.INTERNAL_SERVER_ERROR);
    }

   @ExceptionHandler(value = AccessDeniedException.class )
   public ResponseEntity<APIResponse> handleAccessDeniedException(AccessDeniedException ex, WebRequest request ) throws IOException {
      return responseUtil.badRequestResponse(APIStatus.ERR_USER_NOT_AUTHORIZED,null,HttpStatus.UNAUTHORIZED);
   }

   @Override
   protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//      return this.handleExceptionInternal(ex, (Object)null, headers, status, request);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new APIResponse<>(APIStatus.REQUEST_PAYLOAD_MISSIONG_OR_INVALID, Constant.ParamError.WRONG_INPUT_PARAMETER));
   }





}
