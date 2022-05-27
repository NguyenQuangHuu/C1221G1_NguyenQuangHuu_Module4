package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import vn.codegym.model.Users;
import vn.codegym.model.UserRole;

import vn.codegym.repository.IUserRoleRepository;
import vn.codegym.repository.IUsersRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IUsersRepository iUsersRepository;

    @Autowired
    private IUserRoleRepository iUserRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = this.iUsersRepository.findAccountByUsername(username);

        if(users == null){
            System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        List<UserRole> userRoles = this.iUserRoleRepository.findUserRoleByUsers_Username(users.getUsername());
        List<String> roleName = new ArrayList<>();
        for (UserRole ar:
                userRoles) {
            roleName.add(ar.getRoles().getName());
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        for (String role:
             roleName) {
            GrantedAuthority authority = new SimpleGrantedAuthority(role);
            grantedAuthorities.add(authority);
        }

        return (UserDetails) new User(users.getUsername(), new BCryptPasswordEncoder().encode(users.getPassword()),grantedAuthorities);
    }
}
