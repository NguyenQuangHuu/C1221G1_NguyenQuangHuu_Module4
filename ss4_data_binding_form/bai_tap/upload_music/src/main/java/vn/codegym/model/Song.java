package vn.codegym.model;

public class Song {
    private String songName;
    private String author;
    private String kindOfMusic;
    private String songUrl;

    public Song(String songName, String author, String kindOfMusic, String songUrl) {
        this.songName = songName;
        this.author = author;
        this.kindOfMusic = kindOfMusic;
        this.songUrl = songUrl;
    }

    public Song() {
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
