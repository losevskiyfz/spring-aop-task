package com.losevskiyfz.springaoptask.service;

import com.losevskiyfz.springaoptask.model.User;

import java.util.Optional;

public interface UserService {
    User save(User user);
    Optional<User> getUserById(int id);
}
