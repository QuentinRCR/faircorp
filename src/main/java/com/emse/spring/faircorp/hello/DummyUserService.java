package com.emse.spring.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DummyUserService implements UserService{

    private GreetingService greetService;

    @Autowired
    public DummyUserService(GreetingService greetService) {
        this.greetService = greetService;
    }

    @Override
    public void greetAll() {
        List<String> listeNom= List.of("Elodie","Charles");
        for (String nom : listeNom){
            greetService.greet(nom);
        }

    }

}
