package vn.codegym.model;


import javax.persistence.*;

@Entity
@Table(name="song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "song_name")
    private String songName;
    private String author;

    @Column(name = "kind_of_music")
    private String kindOfMusic;

    @Column(name="song_url")
    private String songUrl;

    public Song(String songName, String author, String kindOfMusic, String songUrl) {
        this.songName = songName;
        this.author = author;
        this.kindOfMusic = kindOfMusic;
        this.songUrl = songUrl;
    }

    public Song() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }
}
