package com.chandu.onlinemess.common.util;

import com.chandu.onlinemess.common.enums.APIStatus;
import com.chandu.onlinemess.common.util.Constant;
import com.chandu.onlinemess.dto.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ResponseUtil {

    private APIResponse _createAPIResponse(APIStatus apiStatus, Object data) {
        return new APIResponse(apiStatus, data);
    }

    public ResponseEntity<APIResponse> buildResponse(APIStatus apiStatus, Object data, HttpStatus httpStatus) {
       return ResponseEntity.status(httpStatus).body(_createAPIResponse(apiStatus, data));
    }

    public ResponseEntity<APIResponse> successResponse(Object data) {
        return buildResponse(APIStatus.OK, data, HttpStatus.OK);
    }

    public ResponseEntity<APIResponse> badRequestResponse(APIStatus apiStatus, List<Constant.ParamError> errors, HttpStatus httpStatus) {

        Map<String, String> errMap = null;

        if (errors != null) {

            errMap = new HashMap<>();
            for (Constant.ParamError error : errors) {
                errMap.put(error.getName(), error.getDesc());
            }
        }

        if (apiStatus == null) {
           apiStatus = APIStatus.ERR_BAD_REQUEST;
        }
        if (httpStatus == null) {
           httpStatus = HttpStatus.BAD_REQUEST;
        }

        return buildResponse(apiStatus, errMap, httpStatus);
    }
}
