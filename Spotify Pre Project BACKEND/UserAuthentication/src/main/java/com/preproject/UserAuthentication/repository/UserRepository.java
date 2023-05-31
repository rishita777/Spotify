package com.preproject.UserAuthentication.repository;

import com.preproject.UserAuthentication.domain.User;
import com.preproject.UserAuthentication.exception.UserNotFound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
