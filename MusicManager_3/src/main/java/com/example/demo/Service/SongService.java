package com.example.demo.Service;

import com.example.demo.Exception.NotFoundException;
import com.example.demo.Model.Song;
import com.example.demo.Repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    //CRUD
    public Song createSong(Song song){
        return songRepository.save(song);
    }

    public Song findById(Long id){
        return songRepository.findById(id).orElse(null);
    }

    public List<Song> findByName(String name){
        return songRepository.findByName(name);
    }

    public List<Song> findAll(){
        return songRepository.findAll();
    }

    public Song updateSong(Long id, Song song){
        Song updatedSong = songRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id, "Song"));

        updatedSong.setName(song.getName());
        updatedSong.setArtist(song.getArtist());
        updatedSong.setGenre(song.getGenre());
        updatedSong.setFilePath(song.getFilePath());

        return songRepository.save(updatedSong);
    }

    public void deleteSong(Long id){
        songRepository.deleteById(id);
    }

}
