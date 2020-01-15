package com.better.dao;

import com.better.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User> userList = new ArrayList<User>();
    static {
        userList.add(new User(1,"zhangsan","123"));
        userList.add(new User(2,"lisi","123"));
        userList.add(new User(3,"wangwu","123"));

    }
    public User findUserByUsernameAndPassword(String username, String password) {
        for (User u : userList) {
            if (u.username.equals(username) && u.password.equals(password)) {
                return u;
            }
        }
        return null;
    }
}
