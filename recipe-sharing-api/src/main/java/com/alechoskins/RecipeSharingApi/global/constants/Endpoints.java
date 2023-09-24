package com.alechoskins.RecipeSharingApi.global.constants;

public class Endpoints {
    public static final String HEALTH_CHECK = "/";

    //region Auth
    public static final String AUTH = "/Auth";
    public static final String AUTH_REGISTER = AUTH + "/Register";
    public static final String AUTH_CONFIRM_EMAIL = AUTH + "/ConfirmEmail";
    public static final String AUTH_LOGIN = AUTH + "/Login";
    public static final String AUTH_LOGOUT = AUTH + "/Logout";
    //endregion

    //region User
    public static final String USER = "/User";
    public static final String USER_GET = USER+"/{id}";
    public static final String USER_GET_ALL = USER+"/All";
    //endregion

    //region Ingredient
    public static final String INGREDIENT = "/Ingredient";
    public static final String INGREDIENT_GET = INGREDIENT+"/{id}";
    public static final String INGREDIENT_GET_ALL = INGREDIENT+"/All";
    public static final String INGREDIENT_SAVE = INGREDIENT+"/Save";
    public static final String INGREDIENT_DELETE = INGREDIENT+"/Delete"+"/{id}";
    //endregion

    //region Recipe
    public static final String RECIPE = "/Recipe";
    public static final String RECIPE_GET_BY_ID = RECIPE+"GetById/{id}";
    public static final String RECIPE_GET_BY_NAME = RECIPE+"GetByName/{name}";
    public static final String RECIPE_GET_ALL = RECIPE+"/All";
    public static final String RECIPE_SAVE = RECIPE+"/Save";
    public static final String RECIPE_DELETE = RECIPE+"/Delete"+"/{id}";
    //endregion

}
