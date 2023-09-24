package com.alechoskins.RecipeSharingApi.database.pojos;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class AppUser implements UserDetails {

    //region PROPERTIES

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String email;
    private String emailVerificationCode;

    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean isAccountNonExpired;
    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean isAccountNonLocked;
    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean isCredentialsNonExpired;
    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean isEnabled;
    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean isDeleted;
    //endregion

    //region RELATIONSHIPS


    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL)
    private List<User_Role> userRoles;

    //endregion

    //region METHODS

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(userRoles != null){
            return userRoles.stream().map(
                    x -> new SimpleGrantedAuthority( x.getRole().getName() )
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
