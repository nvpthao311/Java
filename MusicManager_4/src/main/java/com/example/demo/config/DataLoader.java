package com.example.demo.config;

import com.example.demo.Model.Playlist;
import com.example.demo.Model.PlaylistSong;
import com.example.demo.Model.Song;
import com.example.demo.Repository.PlaylistRepository;
import com.example.demo.Repository.PlaylistSongRepository;
import com.example.demo.Repository.SongRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.*;

@Configuration
public class DataLoader {

    @Bean
    @Order(1)
    CommandLineRunner loadSongs(SongRepository songRepository) {
        return args -> {
            if (songRepository.count() == 0) {
                List<Song> songs = new ArrayList<>();
                for (int i = 1; i <= 100; i++) {
                    Song song = new Song();
                    StringBuilder name = randomName();
                    song.setName("Song " + name + i);
                    song.setArtist("Artist " + ((i % 10) + 1));
                    song.setGenre(i % 2 == 0 ? "Pop" : "Rock");
                    song.setFilePath("/music/song" + i + ".mp3");
                    songs.add(song);
                }
                songRepository.saveAll(songs);
            }
        };
    }

    @Bean
    @Order(2)
    CommandLineRunner loadPlaylists(PlaylistRepository playlistRepository) {
        return args -> {
            if (playlistRepository.count() == 0) {
                List<Playlist> playlists = new ArrayList<>();
                for (int i = 1; i <= 100; i++) {
                    Playlist playlist = new Playlist();
                    StringBuilder name = randomName();
                    playlist.setName("Playlist " + name + i);
                    playlists.add(playlist);
                }
                playlistRepository.saveAll(playlists);
            }
        };
    }

    @Bean
    @Order(3)
    CommandLineRunner loadPlaylistSongs(PlaylistRepository playlistRepository, SongRepository songRepository, PlaylistSongRepository playlistSongRepository) {
        return args -> {
            List<Playlist> playlists = playlistRepository.findAll();
            List<Song> songs = songRepository.findAll();

            List<PlaylistSong> playlistSongs = createRandomPlaylistSongs(playlists, songs);

            playlistSongRepository.saveAll(playlistSongs);
        };
    }

    public List<PlaylistSong> createRandomPlaylistSongs(List<Playlist> playlists, List<Song> songs) {
        List<PlaylistSong> playlistSongs = new ArrayList<>();
        Set<String> uniqueCombinations = new HashSet<>();

        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            Playlist playlist = playlists.get(random.nextInt(0,100));
            Song song = songs.get(random.nextInt(0,100));

            String combination = playlist.getId() + "_" + song.getId();
            if (uniqueCombinations.contains(combination)) {
                i--;
                continue;
            }

            uniqueCombinations.add(combination);
            PlaylistSong playlistSong = new PlaylistSong(playlist, song);
            playlistSongs.add(playlistSong);
        }
        return playlistSongs;
    }

    public StringBuilder randomName(){
        Random random = new Random();
        String alphabet = "qwertyuiopasdfghjklzxcvbnm";

        StringBuilder randomStr = new StringBuilder();
        for (int j = 0; j < 5; j++) {
            char c = alphabet.charAt(random.nextInt(alphabet.length()));
            randomStr.append(c);
        }

        return randomStr;
    }
}


