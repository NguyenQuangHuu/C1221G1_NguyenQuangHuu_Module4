package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Song;
import vn.codegym.repository.ISongRepository;
import vn.codegym.service.ISongService;
@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public void save(Song song) {
        this.iSongRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return this.iSongRepository.findById(id).orElse(null);
    }

    @Override
    public Song getLast() {
        return this.iSongRepository.findFirstByOrderByIdDesc();
    }
}
