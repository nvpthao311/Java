package com.example.demo.Service;

import com.example.demo.Model.Playlist;
import com.example.demo.Model.Song;
import com.example.demo.Repository.PlaylistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlaylistServiceTest {

    @Mock
    private PlaylistRepository playlistRepository;

    @InjectMocks
    private PlaylistService playlistService;

    private Playlist p1, p2, p3;

    @BeforeEach
    void setup(){

        p1 = new Playlist(1L, "playlist1", null);
        p2 = new Playlist(2L, "playlist2", null);
        p3 = new Playlist(3L, "playlist3", null);
    }

    @Test
    void createPlaylist() {
        when(playlistRepository.save(any(Playlist.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        Playlist actual = playlistService.createPlaylist(p1);
        assertEquals(p1, actual);
    }

    @Test
    void findById() {
        when(playlistRepository.findById(2L)).thenReturn(Optional.of(p2));

        Playlist actual = playlistService.findById(2L);
        assertEquals(p2, actual);
    }

    @Test
    void findByName() {
        when(playlistRepository.findByName("playlist2")).thenReturn(List.of(p2));

        List<Playlist> actual = playlistService.findByName("playlist2");
        assertEquals(p2, actual.get(0));
    }

    @Test
    void findAll() {
        List<Playlist> playlists = Arrays.asList(p1, p2, p3);
        when(playlistRepository.findAll()).thenReturn(playlists);

        List<Playlist> actual = playlistService.findAll();
        assertEquals(playlists, actual);
    }

    @Test
    void updatePlaylist() {
        Playlist p = new Playlist(1L, "playlist--", null);

        when(playlistRepository.findById(1L)).thenReturn(Optional.of(p1));
        when(playlistRepository.save(any(Playlist.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));


        Playlist actual = playlistService.updatePlaylist(1L, p);
        assertEquals(p, actual);
    }

    @Test
    void deletePlaylist() {
        playlistService.deletePlaylist(4L);

        verify(playlistRepository, times(1)).deleteById(4L);

    }

}