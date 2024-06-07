package com.losevskiyfz.springaoptask.client;

import com.losevskiyfz.springaoptask.model.User;
import com.losevskiyfz.springaoptask.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ClientApp implements Client {

    private static final AtomicInteger counter = new AtomicInteger();

    private final UserRepository userRepository;

    public ClientApp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String findUserById(int id) {
        return userRepository
                .getUserById(id)
                .map(User::name)
                .orElse("Not found");
    }

    @Override
    public String saveUser(String name, int age) {
        userRepository.save(new User(counter.incrementAndGet(), name, age));
        return "User is saved";
    }

}
