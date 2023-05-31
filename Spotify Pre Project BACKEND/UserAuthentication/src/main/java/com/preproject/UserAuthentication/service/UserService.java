package com.preproject.UserAuthentication.service;

import com.preproject.UserAuthentication.domain.User;
import com.preproject.UserAuthentication.exception.UserNotFound;

public interface UserService
{
    public User savingUser(User user) throws UserNotFound;
    public User login(String emailId, String password);
}

