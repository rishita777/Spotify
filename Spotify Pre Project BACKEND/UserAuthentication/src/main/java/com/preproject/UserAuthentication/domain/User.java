package com.preproject.UserAuthentication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User
{
    @Id
    private String userEmail;
    private String firstName;
    private String lastName;
   private  String password;

}
