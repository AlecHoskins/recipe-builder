package com.alechoskins.RecipeSharingApi.global.constants;

public class Endpoints {
    public static final String HEALTH_CHECK = "/";

    public static final String AUTH = "/Auth";
    public static final String AUTH_REGISTER = AUTH + "/Register";
    public static final String AUTH_CONFIRM_EMAIL = AUTH + "/ConfirmEmail";
    public static final String AUTH_LOGIN = AUTH + "/Login";
    public static final String AUTH_LOGOUT = AUTH + "/Logout";

    public static final String USER = "/AppUser";
    public static final String USER_GET = USER+"/{id}";
    public static final String USER_GET_ALL = USER+"/All";

}
