package com.chandu.onlinemess.common.util;

public class Constant {

    public static final String API_FORMAT_DATE = "yyyy/MM/dd HH:mm:ss";

    public static final String MEAL_CREATE_DATE_FORMAT = "yyyy-MM-dd";

    public static final String MEAL_CREATE_TIME_FORMAT = "HH:mm";

    public static final Integer EXPECTED_CALORIES = 2000;

    public enum ParamError {

        MISSING_USERNAME_AND_EMAIL("accountName", "Missing both user name and email address"),
        USER_NAME("userName", "Invalid user name"),
        EMAIL_ADDRESS("email", "Invalid email address"),
        PASSWORD("passwordHash", "Invalid password hash"),
        PHONE_NUMBER("phone", "Invalid phone number"),
        FIRST_NAME("firstName", "Invalid first name"),
        LAST_NAME("lastName", "Invalid last name"),
        APP_NAME("appName", "Invalid app name"),
        APP_DOMAIN("appDomain", "Invalid app domain"),
        SERVER_KEY("serverKey", "Invalid server key"),
        TOKEN_EXPIRE_DURATION("tokenExpireDuration", "Invalid token expiry duration"),
        REDIRECT_URL("redirectUrl", "Invalid redirect URL"),
        ROLE_NAME("roleName", "Invalid role name"),
        ROLE_DESC("roleDescription", "Invalid role description"),
        NOT_AUTHORIZED_TO_PERFORM_ACTION("authorization","Not Authorized to perform this action"),
        USER_NOT_FOUND("err","User not found"),
        WRONG_INPUT_PARAMETER ("err","Input Parameters are either  missing or  invalid") ;
       private final String name;
        private final String desc;

        private ParamError(String name, String desc) {
            this.name = name;
            this.desc = desc;
        }

        public String getName() {
            return name;
        }

        public String getDesc() {
            return desc;
        }
    }
}
