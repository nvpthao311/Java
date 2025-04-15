package com.example.demo.Controller;


import com.example.demo.Model.Playlist;
import com.example.demo.Service.PlaylistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

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
    void findAll() throws Exception{
        when(playlistService.findAll()).thenReturn(List.of(p1, p2, p3));

        mockMvc.perform(get("/playlists"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }

    @Test
    void findByName() throws Exception{
        when(playlistService.findByName("playlist1")).thenReturn(List.of(p1));

        mockMvc.perform(get("/playlists/name/playlist1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("playlist1"));
    }

    @Test
    void createPlaylist() throws Exception{
        when(playlistService.createPlaylist(p3)).thenReturn(p3);
        ObjectMapper objectMapper = new ObjectMapper();


        mockMvc.perform(post("/playlists")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(p3)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.name").value("playlist3"));

        verify(playlistService, times(1)).createPlaylist(p3);
    }

    @Test
    void updatePlaylist() throws Exception{
        when(playlistService.updatePlaylist(3L, p3)).thenReturn(p3);
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(put("/playlists/3")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(p3)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.name").value("playlist3"));
    }

    @Test
    void deletePlaylist() throws Exception{
        mockMvc.perform(delete("/playlists/3"));

        verify(playlistService, times(1)).deletePlaylist(3L);
    }

}