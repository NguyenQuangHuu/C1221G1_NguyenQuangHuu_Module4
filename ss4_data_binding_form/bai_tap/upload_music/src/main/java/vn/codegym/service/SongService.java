package vn.codegym.service;

import vn.codegym.model.Song;

import java.util.List;

public interface SongService {

    List<Song> getAllSong();

    void newSong(Song song);
}
