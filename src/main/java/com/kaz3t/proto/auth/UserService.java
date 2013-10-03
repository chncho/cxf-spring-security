package com.kaz3t.proto.auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Named("userService")
public class UserService implements UserDetailsService {

    private Map<String, User> users;

    {
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        users = new HashMap<>();
        users.put("foo", new User("foo", "bar", authorities));
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = users.get(username);

        if (user != null) {
            return user;
        }

        throw new UsernameNotFoundException("User: " + username
                + " does not exist.");
    }

}
