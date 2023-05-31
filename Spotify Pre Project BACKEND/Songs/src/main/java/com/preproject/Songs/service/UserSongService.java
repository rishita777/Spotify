package com.preproject.Songs.service;

import com.preproject.Songs.domain.Playlist;
import com.preproject.Songs.domain.SongList;
import com.preproject.Songs.domain.User;
import com.preproject.Songs.exception.PlaylistAlreadyExist;
import com.preproject.Songs.exception.SongAlreadyExistExp;
import com.preproject.Songs.exception.UserAlreadyExist;
import com.preproject.Songs.exception.UserNotFound;

import java.util.List;

public interface UserSongService
{

    public User addUser(User user) throws UserAlreadyExist;
    public User addPlaylistToUser(Playlist playlist, String email) throws UserNotFound;

    public List<Playlist> fetchAllPlaylist(String email);
    public List<SongList> fetchSongsFromPlaylist(String playlistName,String email);
    public Playlist addSongToPlaylist(SongList songList,String playlistName,String email);
    public boolean deleteSongFromPlaylist(int songId,String playlistName,String email);
    public boolean deletePlaylist(String playlistName,String email);

}









