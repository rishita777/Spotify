package com.preproject.Songs.proxy;

import com.preproject.Songs.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="UserService",url="localhost:6089")
public interface UserSongProxy
{
@PostMapping("/api/v1/user/register")
    public ResponseEntity<?> saveUser(@RequestBody User user);
}
