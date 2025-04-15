package com.example.demo.Service;

import com.example.demo.Model.Playlist;
import com.example.demo.Model.Song;
import com.example.demo.Repository.PlaylistRepository;
import com.example.demo.Repository.SongRepository;
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
class SongServiceTest {

    @Mock
    private SongRepository songRepository;

    @InjectMocks
    private SongService songService;

    private Song s1, s2, s3, s4, s5, s6;

    @BeforeEach
    void setup() {

        s1 = new Song(1L,"what do you mean", "Justin", "pop", "uploads/song1.mp3", null);
        s2 = new Song(2L, "Timber","PitBull",null,"uploads/song2.mp3", null);
        s3 = new Song(3L, "Hello","Adel", null, "uploads/song3.mp3", null);
        s4 = new Song(4L, "lock what you made me do","Taylor", null, "uploads/song4.mp3", null);
        s5 = new Song(5L, "Hot N Cold", "Katty",null, "uploads/song5.mp3", null);
        s6 = new Song(6L, "Hello", "SHINee", null, "uploads/song6.mp3", null);

    }

    @Test
    void createSong() {
        when(songRepository.save(any(Song.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        Song actual = songService.createSong(s1);
        assertEquals(s1, actual);
    }

    @Test
    void findById() {
        when(songRepository.findById(2L)).thenReturn(Optional.of(s2));

        Song actual = songService.findById(2L);
        assertEquals(s2, actual);
    }

    @Test
    void findByName() {
        when(songRepository.findByName("Hello")).thenReturn(List.of(s3, s6));

        List<Song> actual = songService.findByName("Hello");
        assertEquals(List.of(s3, s6), actual);
    }

    @Test
    void findAll() {
        List<Song> songs = Arrays.asList(s1, s2, s3);
        when(songRepository.findAll()).thenReturn(songs);

        List<Song> actual = songService.findAll();
        assertEquals(songs, actual);
    }

    @Test
    void updateSong() {
        Song s = new Song(5L, "Die young", "Keysha", null,"uploads/song.mp3", null);

        when(songRepository.findById(5L)).thenReturn(Optional.of(s5));
        when(songRepository.save(any(Song.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));


        Song actual = songService.updateSong(5L, s);
        assertEquals(s, actual);
    }

    @Test
    void deleteSong() {
        songService.deleteSong(4L);

        verify(songRepository, times(1)).deleteById(4L);

    }
}