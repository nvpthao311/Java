package com.example.demo.Repository;

import com.example.demo.Model.Playlist;
import com.example.demo.Model.PlaylistSong;
import com.example.demo.Model.PlaylistSongId;
import com.example.demo.Model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface PlaylistSongRepository extends JpaRepository<PlaylistSong, PlaylistSongId> {

    @Query("SELECT ps.song FROM PlaylistSong ps WHERE ps.playlist.id = :playlistId")
    Set<Song> findSongsByPlaylistId(@Param("playlistId") Long playlistId);

    @Query("SELECT ps.playlist FROM PlaylistSong ps WHERE ps.song.id = :songId")
    Set<Playlist> findPlaylistsBySongId(@Param("songId") Long songId);
}
