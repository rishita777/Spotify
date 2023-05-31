package com.preproject.Songs.repository;

import com.preproject.Songs.domain.SongList;
import com.preproject.Songs.domain.User;
import com.preproject.Songs.exception.SongAlreadyExistExp;
import com.preproject.Songs.exception.UserAlreadyExist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSongRepository extends MongoRepository<User,String>
{

}
