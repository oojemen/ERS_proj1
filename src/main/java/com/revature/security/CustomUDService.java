/*
package com.revature.security;

import com.revature.daos.UserDAO;
import com.revature.models.User;
import com.revature.models.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CustomUDService implements UserDetailsService {

    private final UserDAO userDAO;

    @Autowired
    public  CustomUDService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User a = userDAO.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No User Found"));

        User userDetails= new User(a.getUsername(), a.getPassword(), mapRoleToAuthority(a.getRole())) {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public String getPassword() {
                return null;
            }

            @Override
            public String getUsername() {
                return null;
            }

            @Override
            public boolean isAccountNonExpired() {
                return false;
            }

            @Override
            public boolean isAccountNonLocked() {
                return false;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return false;
            }

            @Override
            public boolean isEnabled() {
                return false;
            }
        };
        return userDetails;`
    }

    private Collection<GrantedAuthority> mapRoleToAuthority(Role role) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleTitle()));

        return grantedAuthorities;

    }

    public UserDetails loadUserByID(Authentication auth, int id) throws UsernameNotFoundException {
        int authenticatedUserId = (User) auth.getPrincipal()).getId();
        if (authenticatedUserId == id){
            User p = userDAO.findById(id).orElseThrow(() -> new UsernameNotFoundException("no User found with Id" + id));

            return new User(p.getUsername(), p.getPassword(), mapRoleToAuthority(p.getRole()));
        } else {
            throw new UsernameNotFoundException("Access denied");
        }
    }
}

 */


package com.revature.security;

import com.revature.daos.UserDAO;
import com.revature.models.User;
import com.revature.models.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUDService implements UserDetailsService {

    private final UserDAO userDAO;

    @Autowired
    public CustomUDService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No User Found"));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                mapRoleToAuthority(user.getRole())
        );
    }

    private Collection<? extends GrantedAuthority> mapRoleToAuthority(Role role) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleTitle()));
        return grantedAuthorities;
    }

    public UserDetails loadUserByID(Authentication auth, int id) throws UsernameNotFoundException {
        int authenticatedUserId = ((User) auth.getPrincipal()).getId();
        if (authenticatedUserId == id) {
            User user = userDAO.findById(id)
                    .orElseThrow(() -> new UsernameNotFoundException("No User found with Id " + id));
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    mapRoleToAuthority(user.getRole())
            );
        } else {
            throw new UsernameNotFoundException("Access denied");
        }
    }
}
