package com.example.demo.Service;

import com.example.demo.Exception.NotFoundException;
import com.example.demo.Model.Playlist;
import com.example.demo.Model.Song;
import com.example.demo.Repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    //CRUD
    public Playlist createPlaylist(Playlist playlist){
        return playlistRepository.save(playlist);
    }

    public Playlist findById(Long id){
        return playlistRepository.findById(id).orElse(null);
    }

    public List<Playlist> findByName(String name){
        return playlistRepository.findByName(name);
    }

    public List<Playlist> findAll(){
        return playlistRepository.findAll();
    }

    public Playlist updatePlaylist(Long id, Playlist playlist){
        Playlist updatedPlaylist = playlistRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id, "Playlist" ));

        updatedPlaylist.setName(playlist.getName());

        return playlistRepository.save(updatedPlaylist);
    }

    public void deletePlaylist(Long id){
        playlistRepository.deleteById(id);
    }



}
