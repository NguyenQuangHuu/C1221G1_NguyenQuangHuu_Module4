package vn.codegym.service;

import vn.codegym.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.repository.SongRepository;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongRepository songRepository;

    @Override
    public List<Song> getAllSong() {
        return this.songRepository.findAll();
    }

    @Override
    public void newSong(Song song) {
        this.songRepository.save(song);
    }
}
