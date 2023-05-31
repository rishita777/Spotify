package com.example.SongCollection.controller;

import com.example.SongCollection.domain.ViewSongs;
import com.example.SongCollection.service.UserSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/viewSongs")
@CrossOrigin
public class ViewSongsController
{
    UserSongService userSongService;
    @Autowired
    public ViewSongsController(UserSongService userSongService) {
        this.userSongService = userSongService;
    }
    @GetMapping("/fetch")
    public ResponseEntity<?>getAllSong(){
        return new ResponseEntity<>(userSongService.getAllSongs(), HttpStatus.OK);
    }
    @PostMapping("/addSong")
    public ResponseEntity<?>addSong(@RequestBody ViewSongs songs){
        return new ResponseEntity<>(userSongService.addSong(songs), HttpStatus.CREATED);
    }


}
