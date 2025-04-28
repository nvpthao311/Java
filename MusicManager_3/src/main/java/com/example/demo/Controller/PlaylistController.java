package com.example.demo.Controller;

import com.example.demo.Model.Playlist;
import com.example.demo.Service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/{id}")
    public Playlist findById(@PathVariable Long id){
        return playlistService.findById(id);
    }

    @GetMapping("/name/{name}")
    public List<Playlist> findByName(@PathVariable String name){
        return playlistService.findByName(name);
    }

    @GetMapping
    public List<Playlist> findAll(){
        return playlistService.findAll();
    }

    @PostMapping
    public Playlist createPlaylist(@RequestBody Playlist playlist){
        return playlistService.createPlaylist(playlist);
    }

    @PutMapping("/{id}")
    public Playlist updatePlaylist(@PathVariable Long id, @RequestBody Playlist playlist){
        return playlistService.updatePlaylist(id, playlist);
    }

    @DeleteMapping("/{id}")
    public void deletePlaylist (@PathVariable Long id){
        playlistService.deletePlaylist(id);
    }
}
