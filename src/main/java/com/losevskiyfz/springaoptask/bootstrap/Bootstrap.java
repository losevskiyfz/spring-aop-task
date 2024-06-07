package com.losevskiyfz.springaoptask.bootstrap;

import com.losevskiyfz.springaoptask.client.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final Client clientApp;

    public Bootstrap(Client clientApp) {
        this.clientApp = clientApp;
    }

    @Override
    public void run(String... args) throws Exception {
        clientApp.saveUser("Mike", 22);
        clientApp.saveUser("John", 23);
        clientApp.findUserById(1);
        clientApp.saveUser("Jeremy", 23);
        clientApp.findUserById(1);
    }
}
