package com.example.BootcampProject;

@RestController
public class Controller {
    @RequestMapping("/hello")
    public String sayHi(){
        return "Hi";
    }
}

