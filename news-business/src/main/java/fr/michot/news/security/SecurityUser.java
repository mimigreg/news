package fr.michot.news.security;

import fr.michot.news.entities.UserDb;
import fr.michot.news.entities.UserGroupDb;
import fr.michot.news.entities.UserRoleDb;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * Copyright SMABTP
 * Created by A14830 on 20/01/2015.
 */
public class SecurityUser implements UserDetails {

    private UserDb userDb;

    public SecurityUser(UserDb user) {
        if (user != null) {
            this.userDb = user;
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        // User's Role
        Set<UserRoleDb> userRoles = userDb.getUserRoleDbs();
        if (userRoles != null) {
            for (UserRoleDb role : userRoles) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
                authorities.add(authority);
            }
        }
        // Usergroup's Role
        Set<UserGroupDb> userGroupDbs = userDb.getUserGroupDbs();
        if(userGroupDbs!=null) {
            for (UserGroupDb userGroup :userGroupDbs ) {
                Set<UserRoleDb> groupeRoles = userGroup.getUserRoleDbs();
                for (UserRoleDb role : groupeRoles) {
                    SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
                    authorities.add(authority);
                }
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return userDb.getPass();
    }

    @Override
    public String getUsername() {
        return userDb.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
