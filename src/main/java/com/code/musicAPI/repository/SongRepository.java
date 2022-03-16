package com.code.musicAPI.repository;

import com.code.musicAPI.model.Song;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {

}
