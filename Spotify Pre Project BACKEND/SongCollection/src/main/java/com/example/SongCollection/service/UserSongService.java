package com.example.SongCollection.service;

import com.example.SongCollection.SongCollectionApplication;
import com.example.SongCollection.domain.ViewSongs;

import java.util.List;

public interface UserSongService
{
    public List<ViewSongs> getAllSongs();

    public ViewSongs addSong(ViewSongs songs);
}
