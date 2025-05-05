package com.example.demo.Controller;

import com.example.demo.Model.Song;
import com.example.demo.Service.SongService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/songs")
@Tag(name = "Song Controller", description = "Operations related to songs")
public class SongController {

    @Autowired
    private SongService songService;

    @Operation(summary = "Get song by ID", description = "Retrieve a song by its ID")
    @GetMapping("/{id}")
    public Song findById(@Parameter(description = "ID of the song to be fetched") @PathVariable Long id) {
        return songService.findById(id);
    }

    @Operation(summary = "Get songs by name", description = "Retrieve a list of songs that match the given name")
    @GetMapping("name/{name}")
    public List<Song> findByName(@Parameter(description = "Name of the song to search for") @PathVariable String name) {
        return songService.findByName(name);
    }

    @Operation(summary = "Get all songs", description = "Retrieve a list of all songs")
    @GetMapping
    public List<Song> findAll() {
        return songService.findAll();
    }

    @Operation(summary = "Create a new song", description = "Create a new song with the provided information")
    @PostMapping
    public Song createSong(@RequestBody Song song) {
        return songService.createSong(song);
    }

    @Operation(summary = "Update song by ID", description = "Update an existing song by its ID")
    @PutMapping("/{id}")
    public Song updateSong(
            @Parameter(description = "ID of the song to be updated") @PathVariable Long id,
            @RequestBody Song song) {
        return songService.updateSong(id, song);
    }

    @Operation(summary = "Delete song by ID", description = "Delete a song by its ID")
    @DeleteMapping("/{id}")
    public void deleteSong(@Parameter(description = "ID of the song to be deleted") @PathVariable Long id) {
        songService.deleteSong(id);
    }
}


