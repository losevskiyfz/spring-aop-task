package com.losevskiyfz.springaoptask.repository;

import com.losevskiyfz.springaoptask.aspect.Cacheable;
import com.losevskiyfz.springaoptask.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private final Map<Integer,User> dataSource = new HashMap<>();

    @Override
    public User save(User user) {
        return dataSource.put(user.id(), user);
    }

    @Override
    @Cacheable
    public Optional<User> getUserById(int id) {
        return Optional.ofNullable(dataSource.get(id));
    }

}
