package com.losevskiyfz.springaoptask.client;

import com.losevskiyfz.springaoptask.model.User;
import com.losevskiyfz.springaoptask.service.UserService;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ClientApp{

    private static final AtomicInteger counter = new AtomicInteger();

    private final UserService userService;

    public ClientApp(UserService userService) {
        this.userService = userService;
    }

    public String findUserById(int id) {
        return userService
                .getUserById(id)
                .map(User::name)
                .orElse("Not found");
    }

    public String saveUser(String name, int age) {
        userService.save(new User(counter.incrementAndGet(), name, age));
        return "User is saved";
    }

}
