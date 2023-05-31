package com.example.SongCollection.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class ViewSongs
{
    @Id
    private int songId;
    private String songName;
    private String artistName;
    private String genre;
    private String album;
    private String duration;


}
