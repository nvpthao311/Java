package com.example.demo.Controller;

import com.example.demo.Model.Playlist;
import com.example.demo.Model.PlaylistSong;
import com.example.demo.Model.Song;
import com.example.demo.Service.PlaylistSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/playlistSong")
public class PlaylistSongController {

    @Autowired
    private PlaylistSongService playlistSongService;

    @PostMapping("/playlists/{playlistId}/songs/{songId}")
    public PlaylistSong addSongToPlaylist(@PathVariable Long playlistId,@PathVariable Long songId){
        return playlistSongService.addSongToPlaylist(playlistId, songId);
    }

    @DeleteMapping("/playlists/{playlistId}/songs/{songId}")
    public void removeSongFromPlaylist(@PathVariable Long playlistId, @PathVariable Long songId){
        playlistSongService.removeSongFromPlaylist(playlistId, songId);
    }

    @GetMapping("/playlists/{playlistId}/songs")
    public Set<Song> getSongsByPlaylist(@PathVariable Long playlistId){
        return playlistSongService.getSongsByPlaylist(playlistId);
    }

    @GetMapping("/songs/{songId}/playlists")
    public Set<Playlist> getPlaylistsBySong(@PathVariable Long songId){
        return playlistSongService.getPlaylistsBySong(songId);
    }

}
