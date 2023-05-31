package com.preproject.Songs.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class User
{
    @Id
    private String userEmail;
    private String firstName;
    private String lastName;
    private  String password;
    private List<Playlist> playlists;

}
