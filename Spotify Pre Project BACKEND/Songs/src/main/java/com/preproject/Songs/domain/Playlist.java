package com.preproject.Songs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Playlist
{
    @Id
    private String playlistName;
    private List<SongList> songsList;
}
