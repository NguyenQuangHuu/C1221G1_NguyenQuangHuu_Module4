package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Song;

public interface ISongRepository extends JpaRepository<Song,Integer> {
    Song findFirstByOrderByIdDesc();
}
