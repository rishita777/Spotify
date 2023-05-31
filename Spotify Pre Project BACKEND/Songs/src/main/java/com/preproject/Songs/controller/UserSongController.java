package com.preproject.Songs.controller;
import com.preproject.Songs.domain.Playlist;
import com.preproject.Songs.domain.SongList;
import com.preproject.Songs.domain.User;
import com.preproject.Songs.exception.UserAlreadyExist;
import com.preproject.Songs.exception.UserNotFound;
import com.preproject.Songs.repository.UserSongRepository;
import com.preproject.Songs.service.UserSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/playlist")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class UserSongController
{
UserSongService userSongService;
    @Autowired
    public UserSongController(UserSongService userSongService) {
        this.userSongService = userSongService;
    }

    @PostMapping("/register")
    public ResponseEntity<?>addUser(@RequestBody User user) throws UserAlreadyExist {
        try {
            return new ResponseEntity<>(userSongService.addUser(user),HttpStatus.CREATED);
        } catch (UserAlreadyExist e) {
            throw new UserAlreadyExist();
        }
    }
    @PostMapping("/play/addPlaylist/{email}")
    public ResponseEntity<?> addPlaylistToUser(@RequestBody Playlist playlist, @PathVariable String email) throws UserNotFound {
        return new ResponseEntity<>(userSongService.addPlaylistToUser(playlist,email),HttpStatus.CREATED);
    }

    @GetMapping("/play/fetchPlaylist/{email}")
    public ResponseEntity<?> getPlaylist(@PathVariable String email)
    {
        return new ResponseEntity<>(userSongService.fetchAllPlaylist(email),HttpStatus.OK);
    }

    @GetMapping("/play/getSongFromPlaylist/{email}/{playlistName}")
    public ResponseEntity<?> getPlaylistSong(@PathVariable String playlistName,@PathVariable String email)
    {
        return new ResponseEntity<>(userSongService.fetchSongsFromPlaylist(playlistName,email),HttpStatus.OK);
    }

    @PostMapping("/play/addSongToPlaylist/{email}/{playlistName}")
    public ResponseEntity<?> addSongToPlaylist(@RequestBody SongList song,@PathVariable String playlistName,@PathVariable String email)
    {
        return new ResponseEntity<>(userSongService.addSongToPlaylist(song,playlistName,email),HttpStatus.CREATED);
    }
    @DeleteMapping("/play/deleteSongFromPlaylist/{email}/{songId}/{playlistName}")
    public ResponseEntity<?> deleteSongFromPlaylist(@PathVariable int songId,@PathVariable String playlistName,@PathVariable String email)
    {
        return new ResponseEntity<>(userSongService.deleteSongFromPlaylist(songId,playlistName,email),HttpStatus.OK);
    }
    @DeleteMapping("/play/deletePlaylist/{email}/{playlistName}")
    public ResponseEntity<?> deletePlaylist(@PathVariable String playlistName,@PathVariable String email)
    {
        return new ResponseEntity<>(userSongService.deletePlaylist(playlistName,email),HttpStatus.OK);
    }
}
