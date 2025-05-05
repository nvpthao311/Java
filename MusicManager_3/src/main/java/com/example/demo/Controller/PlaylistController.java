package com.example.demo.Controller;

import com.example.demo.Model.Playlist;
import com.example.demo.Service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.List;

@Tag(name = "Playlist Controller", description = "Manage music playlists")
@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @Operation(summary = "Get playlist by ID", description = "Retrieve a playlist by its ID")
    @GetMapping("/{id}")
    public Playlist findById(
            @Parameter(description = "ID of the playlist", required = true)
            @PathVariable Long id) {
        return playlistService.findById(id);
    }

    @Operation(summary = "Get playlists by name", description = "Retrieve playlists matching the given name")
    @GetMapping("/name/{name}")
    public List<Playlist> findByName(
            @Parameter(description = "Name of the playlist to search", required = true)
            @PathVariable String name) {
        return playlistService.findByName(name);
    }

    @Operation(summary = "Get all playlists", description = "Retrieve a list of all playlists")
    @GetMapping
    public List<Playlist> findAll() {
        return playlistService.findAll();
    }

    @Operation(summary = "Create a new playlist", description = "Create a new playlist with provided information")
    @PostMapping
    public Playlist createPlaylist(
            @Parameter(description = "Playlist object to be created", required = true)
            @RequestBody Playlist playlist) {
        return playlistService.createPlaylist(playlist);
    }

    @Operation(summary = "Update playlist by ID", description = "Update an existing playlist using its ID")
    @PutMapping("/{id}")
    public Playlist updatePlaylist(
            @Parameter(description = "ID of the playlist to update", required = true)
            @PathVariable Long id,
            @Parameter(description = "Updated playlist object", required = true)
            @RequestBody Playlist playlist) {
        return playlistService.updatePlaylist(id, playlist);
    }

    @Operation(summary = "Delete playlist by ID", description = "Delete a playlist using its ID")
    @DeleteMapping("/{id}")
    public void deletePlaylist(
            @Parameter(description = "ID of the playlist to delete", required = true)
            @PathVariable Long id) {
        playlistService.deletePlaylist(id);
    }
}

