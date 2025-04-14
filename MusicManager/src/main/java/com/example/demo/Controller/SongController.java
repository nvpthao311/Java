package com.example.demo.Controller;

import com.example.demo.Model.Playlist;
import com.example.demo.Model.Song;
import com.example.demo.Service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping("/{id}")
    public Song findById(@PathVariable Long id){
        return songService.findById(id);
    }

    @GetMapping("/{name}")
    public List<Song> findByName(@PathVariable String name){
        return songService.findByName(name);
    }

    @GetMapping
    public List<Song> findAll(){
        return songService.findAll();
    }

    @PostMapping
    public Song createSong(@RequestBody Song song){
        return songService.createSong(song);
    }

    @PutMapping("/{id}")
    public Song updateSong(@PathVariable Long id, @RequestBody Song song){
        return songService.updateSong(id, song);
    }

    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable Long id){
        songService.deleteSong(id);
    }
}
