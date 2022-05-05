package vn.codegym.repository;

import vn.codegym.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepositoryImpl implements SongRepository {

    List<Song> songLibrary = new ArrayList<>();

    @Override
    public List<Song> findAll() {
        return this.songLibrary;
    }

    @Override
    public void save(Song song) {
        this.songLibrary.add(song);
    }
}
