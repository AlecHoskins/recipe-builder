package com.alechoskins.RecipeSharingApi.database.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RepoQueryBuilder {

    public EntityQueryObject buildQuery(Class<?> entity){
        var obj = new EntityQueryObject();
        obj.select().from();
        return EntityQueryObject.builder()
                .entity(entity)
                .params( Arrays.stream(entity.getDeclaredFields())
                                .collect(HashMap::new, (map, field) -> {
                                            map.put(field.getName(), field.getName());
                                        }, HashMap::putAll
                                )
                        )
                .build();
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    private static class EntityQueryObject{
        private Class<?> entity;
        private HashMap<String, String> params;

        private String query;


        public EntityQueryObject from(){
            return this;
        }

        //region Query Sections

        //region Select
        public EntityQueryObject select(){
            return this;
        }

        private class FromSection{
            private final String select = "SELECT ";
            private List<String> properties;

        }
        //endregion

        //endregion
    }

    //"SELECT u FROM AppUser u LEFT JOIN FETCH u.userRoles ur LEFT JOIN FETCH ur.role WHERE u.username = :username OR u.email = :email"

}
