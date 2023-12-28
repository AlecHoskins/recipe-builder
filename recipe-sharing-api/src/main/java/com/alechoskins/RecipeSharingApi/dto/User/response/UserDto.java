package com.alechoskins.RecipeSharingApi.dto.User.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data @Builder
public class UserDto {
    private long id;
    private String username;
    private String email;
    private List<String> roles;
}
/*
    private String email;
    @Column(nullable = false)
    private String emailVerificationCode;

    @Column(nullable = false)
    private boolean isAccountNonExpired;
    @Column(nullable = false)
    private boolean isAccountNonLocked;
    @Column(nullable = false)
    private boolean isCredentialsNonExpired;
    @Column(nullable = false)
    private boolean isEnabled;
    @Column(nullable = false)
    private boolean isDeleted;
    //endregion

    //region RELATIONSHIPS

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    //endregion

    //region METHODS

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(roles != null){
            return roles.stream().map(
                    x -> new SimpleGrantedAuthority( x.getName() )
            ).toList();
        }
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    //endregion
}

* */