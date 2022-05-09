package vn.codegym.repository;

import vn.codegym.model.Song;

import java.util.List;

public interface SongRepository {
    List<Song> findAll();

    void save(Song song);

    Song findOne(Integer id);

    void editSong(Song song);

    void deleteOne(Song song);
}
