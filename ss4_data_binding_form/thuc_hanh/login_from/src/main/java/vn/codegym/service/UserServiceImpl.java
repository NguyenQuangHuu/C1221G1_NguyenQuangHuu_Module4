package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Login;
import vn.codegym.model.User;
import vn.codegym.repository.UserRepository;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository users;
    @Override
    public User checkLogin(Login login) {
        List<User> users  = this.users.showListUser();
        users.stream().filter().filter()
        for (User u: users) {
            if(u.getAccount().equals(login.getAccount())
                    && u.getPassword().equals(login.getPassword())){
                return u;
            }
        }
        return null;
    }
}
