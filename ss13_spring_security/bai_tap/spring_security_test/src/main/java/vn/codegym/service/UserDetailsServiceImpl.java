package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.codegym.model.Role;
import vn.codegym.model.Users;
import vn.codegym.model.UserRole;
import vn.codegym.repository.IRoleRepository;
import vn.codegym.repository.IUserRepository;
import vn.codegym.repository.IUserRoleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private IRoleRepository iRoleRepository;

    @Autowired
    private IUserRoleRepository iUserRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // tìm kiếm đối tượng user sau khi người dùng nhập user
        Users users = this.iUserRepository.findByUserName(userName);

        if (users == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        // Câu query thuần lấy ra role_name
        List<String> strings = this.iRoleRepository.getRoleName(users.getUserId());
        // [ROLE_USER, ROLE_ADMIN,..];
        System.out.println(strings);
        System.out.println("Found User: " + users.toString());
        //Tiếm kiếm User
        List<UserRole> userRole = this.iUserRoleRepository.findUserRoleByUsers_UserId(users.getUserId());
        List<String> roleName = new ArrayList<>();
        for (UserRole rule: userRole
             ) {
            System.out.println(rule.getRole().getRoleName());
            roleName.add(rule.getRole().getRoleName());
        }



        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

        //Duyệt mảng lấy các quyền của đối tượng đăng nhập vào
        for (String ro : roleName
             ) {
            GrantedAuthority authority = new SimpleGrantedAuthority(ro);
            grantList.add(authority);
        }


        // ROLE_USER, ROLE_ADMIN,..

        return (UserDetails) new User(users.getUserName(), //
                users.getEncrytedPassword(), grantList);
    }

}