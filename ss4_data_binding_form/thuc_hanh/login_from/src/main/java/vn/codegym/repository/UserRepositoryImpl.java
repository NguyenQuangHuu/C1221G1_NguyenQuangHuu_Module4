package vn.codegym.repository;

import org.springframework.stereotype.Repository;
import vn.codegym.model.User;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    public List<User> showListUser() {
        List<User> users = new ArrayList<>();
        users.add(new User("abc","123123","Nguyễn Văn ABC","abc@gmail.com",18));
        users.add(new User("abcd","123123","Nguyễn Văn ABCD","abcd@gmail.com",18));
        users.add(new User("abcde","123123","Nguyễn Văn ABCDE","abc@gmail.com",18));
        users.add(new User("abcdef","123123","Nguyễn Văn ABCDEF","abc@gmail.com",18));
        users.add(new User("abcdefg","123123","Nguyễn Văn ABCDEFG","abc@gmail.com",18));
        users.add(new User("abcdefgh","123123","Nguyễn Văn ABCDEFGH","abc@gmail.com",18));
        return users;
    }
}
