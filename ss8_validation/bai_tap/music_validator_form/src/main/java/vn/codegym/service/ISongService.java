package vn.codegym.service;

import vn.codegym.model.Song;

public interface ISongService {
    void save(Song song);

    Song findById(int id);

    Song getLast();
}
