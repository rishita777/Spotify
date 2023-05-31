package com.example.SongCollection.repository;

import com.example.SongCollection.domain.ViewSongs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSongRepository extends MongoRepository<ViewSongs, Integer> {
}
