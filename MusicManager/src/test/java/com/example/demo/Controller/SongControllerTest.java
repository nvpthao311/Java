package com.example.demo.Controller;

import com.example.demo.Model.Song;
import com.example.demo.Service.SongService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SongController.class)
class SongControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private SongService songService;

    private Song s1, s2, s3, s4, s5, s6;

    @BeforeEach
    void setup() {

        s1 = new Song(1L,"what do you mean", "Justin", "pop", "uploads/song1.mp3", null);
        s2 = new Song(2L, "Timber","PitBull",null,"uploads/song2.mp3", null);
        s3 = new Song(3L, "Hello","Adel", null, "uploads/song3.mp3", null);
        s4 = new Song(4L, "lock what you made me do","Taylor", null, "uploads/song4.mp3", new HashSet<>());
        s5 = new Song(5L, "Hot N Cold", "Katty",null, "uploads/song5.mp3", null);
        s6 = new Song(6L, "Hello", "SHINee", null, "uploads/song6.mp3", null);

    }

    @Test
    void findById() throws Exception{
        when(songService.findById(2L)).thenReturn(s2);

        mockMvc.perform(get("/songs/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2L));

    }

    @Test
    void findAll() throws Exception{
        when(songService.findAll()).thenReturn(List.of(s1, s2, s3));

        mockMvc.perform(get("/songs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }

    @Test
    void findByName() throws Exception{
        when(songService.findByName("Hello")).thenReturn(List.of(s3, s6));

        mockMvc.perform(get("/songs/name/Hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Hello"))
                .andExpect(jsonPath("$[1].name").value("Hello"));
    }

    @Test
    void createSong() throws Exception{
        when(songService.createSong(s4)).thenReturn(s4);
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/songs")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(s4)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(4))
                .andExpect(jsonPath("$.name").value("lock what you made me do"));

    }

    @Test
    void updateSong() throws Exception{
        when(songService.updateSong(4L, s4)).thenReturn(s4);
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(put("/songs/4")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(s4)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(4))
                .andExpect(jsonPath("$.name").value("lock what you made me do"));
    }

    @Test
    void deleteSong() throws Exception{
        mockMvc.perform(delete("/songs/3"));

        verify(songService, times(1)).deleteSong(3L);
    }
}