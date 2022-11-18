package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value =  "/user/create")
    public void createUser(@RequestBody User user) {
        userRepository.createUser(user);
    }

    @PutMapping(value = "/user/{userId}/update")
    public void updateUserById(@PathVariable Long userId,
                                   @RequestBody User user){
        userRepository.updateUserById(userId, user);
    }

    @DeleteMapping(value = "/user/{userId}/delete")
    public void deleteUserById(@PathVariable Long userId){
        userRepository.deleteUserById(userId);
    }

    @GetMapping(value = "/user/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userRepository.getUserById(userId);
    }

    @GetMapping(value = "/user/{firstName}/all")
    public List<User> getUsersByFirstName(@PathVariable String firstName){
        return userRepository.getUsersByFirstName(firstName);
    }

    @GetMapping(value = "/users/all")
    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    @GetMapping(value = "/userId/{firstName}/all")
    public List<Long> getUserIdsByFirstName(@PathVariable String firstName){
        return userRepository.getUserIdsByFirstName(firstName);}
}
