package com.code.musicAPI.service;

import com.code.musicAPI.model.Song;
import com.code.musicAPI.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    SongRepository songRepository;

    public void saveSong(Song song) {
        songRepository.save(song);
    }

    public Iterable<Song> getSongHistory() {
        return songRepository.findAll();
    }

    public Optional<Song> getSong(Long id) {
        return songRepository.findById(id);
    }
}
