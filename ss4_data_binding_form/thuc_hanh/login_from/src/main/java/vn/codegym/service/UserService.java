package vn.codegym.service;

import vn.codegym.model.Login;
import vn.codegym.model.User;

public interface UserService {
    User checkLogin(Login login);
}
