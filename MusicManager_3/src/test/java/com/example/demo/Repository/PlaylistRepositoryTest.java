package com.example.demo.Repository;

import com.example.demo.Model.Playlist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PlaylistRepositoryTest {

    @Autowired
    PlaylistRepository playlistRepository;

    private Playlist p1, p2;

    @BeforeEach
    void setup() {

        p1 = new Playlist("list1");
        p2 = new Playlist("list2");

        playlistRepository.saveAll(Set.of(p1, p2));
    }

    @Test
    void findByName() {
        List<Playlist> playlists = playlistRepository.findByName("list");

        assertEquals(0, playlists.size());
    }

}