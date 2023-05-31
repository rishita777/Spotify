package com.preproject.UserAuthentication.service;

import com.preproject.UserAuthentication.domain.User;

import java.util.Map;

public interface iTokenGenerator {

        public Map<String, String> tokenGeneration(User user);
    }
