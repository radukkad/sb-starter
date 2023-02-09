package com.radukkad.sbstarter.blogs.service;

import com.radukkad.sbstarter.blogs.repository.BlogRepository;
import com.radukkad.sbstarter.blogs.repository.UserRepository;
import com.radukkad.sbstarter.blogs.dao.User;
import com.radukkad.sbstarter.blogs.dto.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    BlogRepository blogRepository;


    public UserModel findUserbyId(int id) {
        UserModel userModel = null;
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            userModel = new UserModel(user.get().getLogon(), user.get().getName());
        }
        return userModel;
    }
}
