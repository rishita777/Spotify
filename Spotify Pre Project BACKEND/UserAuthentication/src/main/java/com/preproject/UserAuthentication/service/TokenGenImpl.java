package com.preproject.UserAuthentication.service;

import com.preproject.UserAuthentication.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenGenImpl implements iTokenGenerator
{

        @Override
        public Map<String, String> tokenGeneration(User user) {
            String jwtToken=null;
            jwtToken=    Jwts.builder().setSubject(user.getFirstName()).
                    setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256,"Security Key").
                    setExpiration(new Date(2023, Calendar.JANUARY,26)).compact();
            Map<String,String>map=new HashMap();
            map.put("token",jwtToken);
            map.put("massage","User Logged In Successfully");
            return map;
        }

}
