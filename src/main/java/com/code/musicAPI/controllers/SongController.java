package com.code.musicAPI.controllers;

import java.util.Optional;

import com.code.musicAPI.exceptions.InvalidSongReferenceException;
import com.code.musicAPI.model.Song;
import com.code.musicAPI.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class SongController {

    @Autowired
    StorageService storageService;

    @PostMapping("/create")
    public Long createSong(@RequestBody Song song) {
        storageService.saveSong(song);
        return song.getSongId();
    }

    @GetMapping("/viewAll")
    public Iterable<Song> viewAllSongs() {
        return storageService.getSongHistory();
    }

    @GetMapping("/view/{id}")
    public Song viewSongById(@PathVariable ("id") Long id) {
        Optional<Song> song = storageService.getSong(id);
        if(song.isPresent()) {
            return song.get();
        }

        throw new InvalidSongReferenceException("Invalid song reference provided");
    }

}
