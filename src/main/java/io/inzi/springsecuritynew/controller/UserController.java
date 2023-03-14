package io.inzi.springsecuritynew.controller;

import io.inzi.springsecuritynew.UserRepository;
import io.inzi.springsecuritynew.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }

    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/user")
    public String user(){
        return "Hi User/Admin!";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String admin(){
        return "Hi Admin!";
    }

    @PostMapping("/save")
    public String addUser(@RequestBody UserEntity user){
        userRepository.save(user);
        return "User added";
    }
}
