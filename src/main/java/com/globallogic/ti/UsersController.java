package com.globallogic.ti;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class UsersController {

    @Value("${technical-interview.users-limit}")
    private Long usersLimit;


    private final HashMap<Long, User> users = new HashMap<>();
    private long id;

    @PostMapping("/users")
    public User create(@RequestBody User user) {
        System.out.println("Current users limit is " + usersLimit);
        return users.put(++id, user);
    }

    @GetMapping("/users")
    public HashMap<Long, User> getAll() {
        return users;
    }
}