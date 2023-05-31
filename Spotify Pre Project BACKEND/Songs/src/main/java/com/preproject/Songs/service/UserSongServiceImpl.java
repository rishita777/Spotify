package com.preproject.Songs.service;

import com.preproject.Songs.domain.Playlist;
import com.preproject.Songs.domain.SongList;
import com.preproject.Songs.domain.User;
import com.preproject.Songs.exception.UserAlreadyExist;
import com.preproject.Songs.exception.UserNotFound;
import com.preproject.Songs.proxy.UserSongProxy;
import com.preproject.Songs.repository.UserSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserSongServiceImpl implements UserSongService
{
    UserSongRepository userSongRepository;
    UserSongProxy userSongProxy;
    @Autowired
    public UserSongServiceImpl(UserSongRepository userSongRepository, UserSongProxy userSongProxy) {
        this.userSongRepository = userSongRepository;
        this.userSongProxy = userSongProxy;
    }
    @Override
    public User addUser(User user) throws UserAlreadyExist
    {

        if(userSongRepository.findById(user.getUserEmail()).isEmpty()){
            userSongProxy.saveUser(user);
            return userSongRepository.save(user);
        }
        throw new UserAlreadyExist();
    }

    @Override
    public User addPlaylistToUser(Playlist playlist, String email) throws UserNotFound {
        User user1=userSongRepository.findById(email).get();
        List<Playlist> playlistList=user1.getPlaylists();

        if (playlistList!= null)
        {
            boolean var=false;
          for (Playlist play :playlistList)
          {
                if(play.getPlaylistName().equals(playlist.getPlaylistName())) {
                    var = true;
                    break;
                }

            }
             if(!var)
             {
                 playlistList.add(playlist);
                 user1.setPlaylists(playlistList);
             }
        }
        else
        {
            user1.setPlaylists(new ArrayList<>());
            user1.getPlaylists().add(playlist);
        }
        userSongRepository.save(user1);
        return user1;

    }

    @Override
    public List<Playlist> fetchAllPlaylist(String email)
    {
        return userSongRepository.findById(email).get().getPlaylists();
    }

    @Override
    public List<SongList> fetchSongsFromPlaylist(String playlistName, String email) {
        List<Playlist> playlist=userSongRepository.findById(email).get().getPlaylists();
        Playlist pLay_list=null;
        for(Playlist p:playlist)
        {
            if(p.getPlaylistName().equals(playlistName))
            {
                pLay_list=p;
            }
        }
        return  pLay_list.getSongsList();
    }

    @Override
    public Playlist addSongToPlaylist(SongList songList, String playlistName, String email) {
        User user=userSongRepository.findById(email).get();
        List<Playlist> playlist=userSongRepository.findById(email).get().getPlaylists();
        Playlist playlist1=null;
        for(Playlist p:playlist)
        {
            if(p.getPlaylistName().equals(playlistName))
            {
                playlist1=p;
            }
        }
        playlist.remove(playlist1);
        List<SongList> songLists=playlist1.getSongsList();
        if(songLists!=null)
        {
            boolean check=false;
            for(SongList songList1:songLists)
            {
                if(songList1.getSongId()==songList.getSongId())
                {
                    check=true;
                }

            }
            if(!check) {
                songLists.add(songList);
                playlist1.setSongsList(songLists);
            }
        }
        else {
            playlist1.setSongsList(new ArrayList<>());
            playlist1.getSongsList().add(songList);
        }
        playlist.add(playlist1);
        user.setPlaylists(playlist);
        userSongRepository.save(user);
        return playlist1;
    }


    @Override
    public boolean deleteSongFromPlaylist(int songId, String playlistName, String email) {
        User user=userSongRepository.findById(email).get();
        List<Playlist> playlist=user.getPlaylists();
        Playlist playlist1=null;
        for(Playlist p:playlist)
        {
            if(p.getPlaylistName().equals(playlistName))
            {
                playlist1=p;
            }
        }
        playlist.remove(playlist1);
        List<SongList> songList=playlist1.getSongsList();
        Iterator<SongList> iterator=songList.iterator();
        while(iterator.hasNext())
        {
            SongList songList1=iterator.next();
            if(songList1.getSongId()==songId)
            {
                iterator.remove();
            }
        }
        playlist1.setSongsList(songList);
        playlist.add(playlist1);
        user.setPlaylists(playlist);
        userSongRepository.save(user);
        return true;
    }

    @Override
    public boolean deletePlaylist(String playlistName, String email) {
        User user=userSongRepository.findById(email).get();
        List<Playlist> playlists=user.getPlaylists();
        Iterator<Playlist> iterator=playlists.iterator();
        while(iterator.hasNext())
        {
            Playlist playlist=iterator.next();
            if(playlist.getPlaylistName().equals(playlistName))
            {
                iterator.remove();
            }
        }
        user.setPlaylists(playlists);
        userSongRepository.save(user);
        return true;
    }


}
