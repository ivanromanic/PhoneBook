package com.fullstack_imenik.Imenik.controller;

import com.fullstack_imenik.Imenik.exceptions.UserNotFoundException;
import com.fullstack_imenik.Imenik.model.user;
import com.fullstack_imenik.Imenik.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class userController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    user newUser(@RequestBody user newUser){
        return userRepository.save(newUser);
    };
    @GetMapping("/users")
    List<user> getAllUsers(){
        return userRepository.findAll();
    };

    @GetMapping("/user/{id}")
    user getUserById(@PathVariable Long id){
        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    user updateUser(@RequestBody user newUser, @PathVariable Long id){
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setSurname(newUser.getSurname());
                    user.setNumber(newUser.getNumber());
                    user.setEmail(newUser.getEmail());
                    user.setAge(newUser.getAge());
                    return userRepository.save(user);
                }).orElseThrow(()->new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        System.out.println("GET /user/" + id);
        return "User with id " + id + " has been deleted successfully.";
    }

}
