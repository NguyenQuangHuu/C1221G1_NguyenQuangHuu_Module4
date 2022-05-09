package vn.codegym.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.model.Song;
import org.springframework.stereotype.Repository;
import vn.codegym.repository.SongRepository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepositoryImpl implements SongRepository {

    @Override
    public List<Song> findAll() {

        TypedQuery<Song> query = BaseRepository.entityManager.createQuery("select s from Song s",Song.class);
        return query.getResultList();
    }

    @Override
    public void save(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(song);
        entityTransaction.commit();
    }

    @Override
    public Song findOne(Integer id) {
        TypedQuery<Song> song = BaseRepository.entityManager.createQuery("" +
                "select s from Song s where id = :id",Song.class);
        song.setParameter("id",id);
        return song.getSingleResult();
    }

    @Override
    public void editSong(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();

        entityTransaction.begin();
        BaseRepository.entityManager.merge(song);
        entityTransaction.commit();
    }

    @Override
    public void deleteOne(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();

        entityTransaction.begin();
        BaseRepository.entityManager.remove(song);
        entityTransaction.commit();

    }
}
