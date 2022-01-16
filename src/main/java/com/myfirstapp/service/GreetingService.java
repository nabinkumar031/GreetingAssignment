package com.myfirstapp.service;

import com.myfirstapp.model.Greeting;
import com.myfirstapp.model.User;
import com.myfirstapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements  IGreetingService{

    private static final String template ="Hello, %s!!";
    private final AtomicLong counter=new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;


    @Override
    public Greeting addGreeting(User user) {
        String message=String.format(template,user.toString().isEmpty() ? "Hello World" : user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(),message));
    }

    @Override
    public Greeting getGreeting(long id) {
        return greetingRepository.getById(id);
    }

    @Override
    public List<Greeting> getAllGreeting() {
        return greetingRepository.findAll();
    }

    @Override
    public Boolean deleteById(long id) {
        greetingRepository.deleteById(id);
        return greetingRepository.existsById(id);
    }

}
