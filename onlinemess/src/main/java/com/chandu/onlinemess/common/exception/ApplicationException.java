package com.chandu.onlinemess.common.exception;

import com.chandu.onlinemess.common.enums.APIStatus;
import com.chandu.onlinemess.common.util.Constant;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;


@Getter
public class ApplicationException extends RuntimeException {

    private APIStatus apiStatus;
    private List<Constant.ParamError> data;
    private HttpStatus httpStatus;

    public ApplicationException(APIStatus apiStatus) {
        this.apiStatus = apiStatus;
    }

    public ApplicationException(APIStatus apiStatus, List<Constant.ParamError> data) {
        this(apiStatus);
        this.data = data;
    }

   public ApplicationException(APIStatus apiStatus, List<Constant.ParamError> data, HttpStatus httpStatus) {
      this(apiStatus,data);
      this.httpStatus = httpStatus;
   }

    public ApplicationException(Throwable cause) {
        super(cause);
    }

}
