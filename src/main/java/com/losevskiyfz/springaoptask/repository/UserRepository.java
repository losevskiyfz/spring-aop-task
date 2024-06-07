package com.losevskiyfz.springaoptask.repository;


import com.losevskiyfz.springaoptask.model.User;

import java.util.Optional;

public interface UserRepository{
    User save(User user);
    Optional<User> getUserById(int id);
}
