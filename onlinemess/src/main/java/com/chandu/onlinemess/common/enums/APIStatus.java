package com.chandu.onlinemess.common.enums;

public enum APIStatus {

    ERR_INVALID_DATA(100, "Input data is not valid."),
    ERR_USER_NOT_EXIST(110, "User does not exist"),
    ERR_USER_NOT_VALID(111, "User name or password is not correct"),
    USER_ALREADY_EXIST(112, "Username already exist"),

    INVALID_PARAMETER(425, "Invalid request parameter"),
    ERR_UNAUTHORIZED(401, "Unauthorized or Access Token is expired"),
    ERR_PERMISSION_DENIED(402, "Access Permission denied"),
    ERR_COMPANY_ID_EMPTY(403, "Company id is requied"),

    OK(200, "success"),
    ERR_INTERNAL_SERVER(500, "Internal Error"),
    ERR_BAD_REQUEST(400, "Bad request"),

    ERR_USER_NOT_FOUND(404, "User Not Found"),
    ERR_MISSING_PASSWORD(407, "Missing new password"),
    ERR_UNCORRECT_PASSWORD(408, "Your old password is uncorrect"),

    ERR_USER_NOT_AUTHORIZED(805, "User not Authorized to perform this action "),

    MEAL_DOES_NOT_EXIST (806,"Meal Doesn't exist"),
    MEAL_DATE_TIME_CAN_NOT_BE_FUTURE(807,"Meal Date and  time can not be futuristic"),
   REQUEST_PAYLOAD_MISSIONG_OR_INVALID(808,"input parameters are missiong or invalid ");


   private final int code;
    private final String description;

    private APIStatus(int s, String v) {
        code = s;
        description = v;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}
