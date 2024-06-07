package com.losevskiyfz.springaoptask.client;

public interface Client {
    String findUserById(int id);
    String saveUser(String name, int age);
}
