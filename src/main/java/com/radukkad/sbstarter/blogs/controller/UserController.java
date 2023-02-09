package com.radukkad.sbstarter.blogs.controller;


import com.radukkad.sbstarter.blogs.repository.UserRepository;
import com.radukkad.sbstarter.blogs.dto.BlogModel;
import com.radukkad.sbstarter.blogs.dao.User;
import com.radukkad.sbstarter.blogs.dto.UserModel;
import com.radukkad.sbstarter.blogs.service.BlogService;
import com.radukkad.sbstarter.blogs.service.BlogServiceImpl;
import com.radukkad.sbstarter.blogs.service.UserService;
import com.radukkad.sbstarter.blogs.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Autowired
    BlogService blogService;


    @GetMapping("/user")
    public List<UserModel> getUsers(){
        List<UserModel> returnUser = new ArrayList<UserModel>();
        List<User> users = userRepository.findAll();
        for(int i=0; i < users.size(); i++) {
            returnUser.add(new UserModel(users.get(i).getLogon(), users.get(i).getName()));
        }
        return returnUser;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable int id){
        UserModel user = userService.findUserbyId(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(user);
    }

    @GetMapping("/user/{id}/blogs")
    public ResponseEntity<UserModel> getBlogsByUserId(@PathVariable int id){
        UserModel user = userService.findUserbyId(id);
        List<BlogModel> blogs = blogService.getBlogsByUser(id);
        user.setBlogs(blogs);
        return ResponseEntity.status(HttpStatus.OK)
                .body(user);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User input) {
        return userRepository.save(input);
    }

}
