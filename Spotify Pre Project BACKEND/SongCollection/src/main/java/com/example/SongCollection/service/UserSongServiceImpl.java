package com.example.SongCollection.service;

import com.example.SongCollection.domain.ViewSongs;
import com.example.SongCollection.repository.UserSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSongServiceImpl implements UserSongService
{
    UserSongRepository userSongRepository;

    @Autowired
    public UserSongServiceImpl(UserSongRepository userSongRepository) {
        this.userSongRepository = userSongRepository;
    }

    @Override
    public List<ViewSongs> getAllSongs() {
        return userSongRepository.findAll();
    }

    @Override
    public ViewSongs addSong(ViewSongs songs) {
        return userSongRepository.save(songs);
    }
}
