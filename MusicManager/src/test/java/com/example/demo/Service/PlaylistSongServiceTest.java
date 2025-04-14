package com.example.demo.Service;

import com.example.demo.Model.Playlist;
import com.example.demo.Model.PlaylistSong;
import com.example.demo.Model.PlaylistSongId;
import com.example.demo.Model.Song;
import com.example.demo.Repository.PlaylistRepository;
import com.example.demo.Repository.PlaylistSongRepository;
import com.example.demo.Repository.SongRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // nếu dùng MySQL thật
class PlaylistSongServiceTest {
    @Autowired
    private PlaylistSongService playlistSongService;
    @Autowired
    private PlaylistRepository playlistRepository;
    @Autowired
    private SongRepository songRepository;
    @Autowired
    private PlaylistSongRepository playlistSongRepository;

    private Playlist playlist;
    private Song song;

    @BeforeEach
    void setup() {
        playlist = playlistRepository.save(new Playlist("My Playlist"));
        song = songRepository.save(new Song("Bohemian Rhapsody", "Queen", "Rock", "/music/queen.mp3"));
    }

    @Test
    void testAddSongToPlaylist() {
        PlaylistSong ps = playlistSongService.addSongToPlaylist(playlist.getId(), song.getId());

        assertNotNull(ps);
        assertEquals(playlist.getId(), ps.getPlaylist().getId());
        assertEquals(song.getId(), ps.getSong().getId());

        // Kiểm tra tồn tại trong DB
        assertTrue(playlistSongRepository.existsById(new PlaylistSongId(playlist.getId(), song.getId())));
    }

    @Test
    void testGetSongsByPlaylist() {
        playlistSongService.addSongToPlaylist(playlist.getId(), song.getId());

        Set<Song> songs = playlistSongService.getSongsByPlaylist(playlist.getId());

        assertEquals(1, songs.size());
        assertTrue(songs.stream().anyMatch(s -> s.getId().equals(song.getId())));
    }

    @Test
    void testRemoveSongFromPlaylist() {
        playlistSongService.addSongToPlaylist(playlist.getId(), song.getId());

        playlistSongService.removeSongFromPlaylist(playlist.getId(), song.getId());

        assertFalse(playlistSongRepository.existsById(new PlaylistSongId(playlist.getId(), song.getId())));
    }


}
