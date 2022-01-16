package com.myfirstapp.service;

import com.myfirstapp.model.Greeting;
import com.myfirstapp.model.User;

import java.util.List;

public interface IGreetingService {
    Greeting addGreeting(User user);
    Greeting getGreeting(long id);
    List<Greeting> getAllGreeting();
    Boolean deleteById(long id);
}
