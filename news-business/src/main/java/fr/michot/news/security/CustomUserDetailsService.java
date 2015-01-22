package fr.michot.news.security;

import fr.michot.news.entities.UserDb;
import fr.michot.news.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Copyright SMABTP
 * Created by A14830 on 20/01/2015.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Inject
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Page<UserDb> user = userRepository.findByEmail(null, username);
        if (user == null || user.getTotalElements()==0) {
            throw new UsernameNotFoundException("UserName " + username + " not found");
        }
        return new SecurityUser(user.getContent().get(0));
    }
}
