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

    @Override
    public Song findOne(Integer id) {
        return this.songRepository.findOne(id);
    }

    @Override
    public void editSong(Song song) {
        this.songRepository.editSong(song);
    }

    @Override
    public void deleteOne(Song song) {
        this.songRepository.deleteOne(song);
    }
}
