package com.alechoskins.RecipeSharingApi.global;

public final class AppEnums {

    public enum RoleNames {
        USER("USER"),
        ADMIN("ADMIN");

        private final String value;

        RoleNames(String value) {
            this.value = value;
        }
        //potentially can delete these getValues
        public String getValue() {
            return value;
        }
        public String checkHasRole() {
            return "hasRole('"+value+"')";
        }
    }

    public enum Permission {
        USER_GET("USER_GET"),
        USER_GET_ALL("USER_GET_ALL"),
        USER_CREATE("USER_CREATE"),
        USER_UPDATE("USER_UPDATE"),
        USER_DELETE("USER_DELETE");

        private final String value;

        Permission(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
