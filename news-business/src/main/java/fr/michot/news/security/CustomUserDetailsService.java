package fr.michot.news.security;

import fr.michot.news.entities.UserDb;
import fr.michot.news.entities.UserRoleDb;
import fr.michot.news.repositories.UserRepository;
import fr.michot.news.repositories.UserRoleRepository;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

/**
 * Copyright MIMIGREG
 * Created by mimigreg on 20/01/2015.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {
    private static final String DEFAULT_ADMIN_EMAIL = "admin@admin.com";
    private static final String DEFAULT_ADMIN_NAME = "admin";
    private static final String DEFAULT_ADMIN_ROLE = "ADMIN";

    @Inject
    UserRepository userRepository;

    @Inject
    UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Page<UserDb> user = userRepository.findByEmail(null, username);
        if (user == null || user.getTotalElements()==0) {
            if(!userRepository.findAll().iterator().hasNext()) { // If no users found, then we create a default admin
                return new SecurityUser(initDefaultAdmin());
            } else {
                throw new UsernameNotFoundException("UserName " + username + " not found");
            }
        }
        return new SecurityUser(user.getContent().get(0));
    }

    @Transactional
    private UserDb initDefaultAdmin() {
        UserRoleDb role = new UserRoleDb();
        role.setRoleName(DEFAULT_ADMIN_ROLE);
        role = userRoleRepository.save(role);
        Set<UserRoleDb> roleDbs = new HashSet<>();
        roleDbs.add(role);

        UserDb user = new UserDb();
        user.setEmail(DEFAULT_ADMIN_EMAIL);
        user.setFirstName(DEFAULT_ADMIN_NAME);
        user.setName(DEFAULT_ADMIN_NAME);
        user.setPass(DEFAULT_ADMIN_NAME);
        user.setUserRoleDbs(roleDbs);
        user = userRepository.save(user);

        return user;
    }
}
