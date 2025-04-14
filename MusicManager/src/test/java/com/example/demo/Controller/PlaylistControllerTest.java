package com.example.demo.Controller;


import com.example.demo.Model.Playlist;
import com.example.demo.Service.PlaylistService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PlaylistController.class)
class PlaylistControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PlaylistService playlistService;

    private Playlist p1, p2, p3;

    @BeforeEach
    void setup(){

        p1 = new Playlist(1L, "playlist1", null);
        p2 = new Playlist(2L, "playlist2", null);
        p3 = new Playlist(3L, "playlist3", null);

    }

    @Test
    void findById() throws Exception{
        when(playlistService.findById(2L)).thenReturn(p2);

        mockMvc.perform(get("/playlists/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2L));

    }

    @Test
    void findAll() {
    }

    @Test
    void createPlaylist() {
    }

    @Test
    void updatePlaylist() {
    }

    @Test
    void deletePlaylist() {
    }
}