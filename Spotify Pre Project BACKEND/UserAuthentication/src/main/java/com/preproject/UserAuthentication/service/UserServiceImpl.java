package com.preproject.UserAuthentication.service;

import com.preproject.UserAuthentication.domain.User;
import com.preproject.UserAuthentication.exception.UserNotFound;
import com.preproject.UserAuthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    UserRepository userRepository;
@Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User savingUser(User user) throws UserNotFound {
        if(userRepository.findById(user.getUserEmail()).isEmpty()){
            return userRepository.save(user);
        }
        throw new UserNotFound();
    }

    @Override
    public User login(String email, String password) {
        if(userRepository.findById(email).isPresent()){
            User user=userRepository.findById(email).get();
            if(user.getPassword().equals(password))
            {
                return user;
            }else
                return null;
        }
        return null;
    }
}
