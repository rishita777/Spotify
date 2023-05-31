package com.preproject.Songs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Duration;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SongList
{
    @Id
    private  int songId;
    private String songName;
    private String album;
    private String artist;
    private String genre;

    private String duration;

    

}
