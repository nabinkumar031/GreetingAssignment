package com.myfirstapp.controller;

import com.myfirstapp.model.Greeting;
import com.myfirstapp.model.User;
import com.myfirstapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private static final String template ="Hello, %s!!";
    private final AtomicLong counter=new AtomicLong();

    @Autowired
    private IGreetingService greetingService;

    @GetMapping(value = {"","/","/home"})
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        User user= new User();
        user.setFirstName(name);
        return greetingService.addGreeting(user);
    }

    @GetMapping("/id/{id}")
    public String getGreetingById(@PathVariable long id){
        Greeting greeting= greetingService.getGreeting(id);
        if(greeting==null) return "NOT FOUND";

        return greeting.getMessage();
        //return "Hello " + name + " !!";
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        greetingService.deleteById(id) ;
    }

    /**
    @GetMapping("/getall")
    public String getAllGreeting(){
        greetingService.getAllGreeting();
    }**/


}
