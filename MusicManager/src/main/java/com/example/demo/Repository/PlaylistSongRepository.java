package com.example.demo.Repository;

import com.example.demo.Model.Playlist;
import com.example.demo.Model.PlaylistSong;
import com.example.demo.Model.PlaylistSongId;
import com.example.demo.Model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PlaylistSongRepository extends JpaRepository<PlaylistSong, PlaylistSongId> {

}
