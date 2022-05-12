package vn.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String singer;
    private String kindOfMusic;
    @Column(columnDefinition = "DATE")
    private String uploadDate;

//    private String pathFile;

    public Song() {
    }

    public Song(String name, String singer, String kindOfMusic, String uploadDate) {
        this.name = name;
        this.singer = singer;
        this.kindOfMusic = kindOfMusic;
        this.uploadDate = uploadDate;
    }

//    public Song(String name, String singer, String kindOfMusic, String uploadDate, String pathFile) {
//        this.name = name;
//        this.singer = singer;
//        this.kindOfMusic = kindOfMusic;
//        this.uploadDate = uploadDate;
//        this.pathFile = pathFile;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

//    public String getPathFile() {
//        return pathFile;
//    }
//
//    public void setPathFile(String pathFile) {
//        this.pathFile = pathFile;
//    }
}
