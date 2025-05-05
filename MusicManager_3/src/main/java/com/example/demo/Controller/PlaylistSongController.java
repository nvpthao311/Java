package com.example.demo.Controller;

import com.example.demo.Model.Playlist;
import com.example.demo.Model.PlaylistSong;
import com.example.demo.Model.Song;
import com.example.demo.Service.PlaylistSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.Set;

@Tag(name = "Playlist-Song Controller", description = "Manage songs in playlists and playlists containing songs")
@RestController
@RequestMapping("/playlistSong")
public class PlaylistSongController {

    @Autowired
    private PlaylistSongService playlistSongService;

    @Operation(summary = "Add a song to a playlist", description = "Add the specified song to the given playlist by ID")
    @PostMapping("/playlists/{playlistId}/songs/{songId}")
    public PlaylistSong addSongToPlaylist(
            @Parameter(description = "ID of the playlist", required = true) @PathVariable Long playlistId,
            @Parameter(description = "ID of the song to add", required = true) @PathVariable Long songId) {
        return playlistSongService.addSongToPlaylist(playlistId, songId);
    }

    @Operation(summary = "Remove a song from a playlist", description = "Remove the specified song from the given playlist by ID")
    @DeleteMapping("/playlists/{playlistId}/songs/{songId}")
    public void removeSongFromPlaylist(
            @Parameter(description = "ID of the playlist", required = true) @PathVariable Long playlistId,
            @Parameter(description = "ID of the song to remove", required = true) @PathVariable Long songId) {
        playlistSongService.removeSongFromPlaylist(playlistId, songId);
    }

    @Operation(summary = "Get songs by playlist", description = "Retrieve all songs from the specified playlist")
    @GetMapping("/playlists/{playlistId}/songs")
    public Set<Song> getSongsByPlaylist(
            @Parameter(description = "ID of the playlist", required = true) @PathVariable Long playlistId) {
        return playlistSongService.getSongsByPlaylist(playlistId);
    }

    @Operation(summary = "Get playlists by song", description = "Retrieve all playlists that contain the specified song")
    @GetMapping("/songs/{songId}/playlists")
    public Set<Playlist> getPlaylistsBySong(
            @Parameter(description = "ID of the song", required = true) @PathVariable Long songId) {
        return playlistSongService.getPlaylistsBySong(songId);
    }
}
