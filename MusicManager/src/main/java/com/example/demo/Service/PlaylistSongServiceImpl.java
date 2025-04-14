package com.example.demo.Service;

import com.example.demo.Exception.NotFoundException;
import com.example.demo.Model.Playlist;
import com.example.demo.Model.PlaylistSong;
import com.example.demo.Model.PlaylistSongId;
import com.example.demo.Model.Song;
import com.example.demo.Repository.PlaylistRepository;
import com.example.demo.Repository.PlaylistSongRepository;
import com.example.demo.Repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PlaylistSongServiceImpl implements PlaylistSongService {

    private final PlaylistRepository playlistRepository;
    private final SongRepository songRepository;
    private final PlaylistSongRepository playlistSongRepository;

    @Override
    public PlaylistSong addSongToPlaylist(Long playlistId, Long songId) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new NotFoundException(playlistId, "Playlist"));

        Song song = songRepository.findById(songId)
                .orElseThrow(() -> new NotFoundException(songId, "Song"));

        PlaylistSongId id = new PlaylistSongId(playlistId, songId);

        // Tránh insert trùng
        if (playlistSongRepository.existsById(id)) {
            throw new IllegalStateException("Song already exists in Playlist");
        }

        PlaylistSong ps = new PlaylistSong(playlist, song);
        return playlistSongRepository.save(ps);
    }

    @Override
    public void removeSongFromPlaylist(Long playlistId, Long songId) {
        PlaylistSongId id = new PlaylistSongId(playlistId, songId);
        if (!playlistSongRepository.existsById(id)) {
            throw new NotFoundException(songId, "Playlist-Song relation");
        }
        playlistSongRepository.deleteById(id);
    }

    @Override
    public Set<Song> getSongsByPlaylist(Long playlistId) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new NotFoundException(playlistId, "Playlist"));

        return playlist.getPlaylistSongs().stream()
                .map(PlaylistSong::getSong)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Playlist> getPlaylistsBySong(Long songId) {
        Song song = songRepository.findById(songId)
                .orElseThrow(() -> new NotFoundException(songId, "Song"));

        return song.getPlaylistSongs().stream()
                .map(PlaylistSong::getPlaylist)
                .collect(Collectors.toSet());
    }
}

