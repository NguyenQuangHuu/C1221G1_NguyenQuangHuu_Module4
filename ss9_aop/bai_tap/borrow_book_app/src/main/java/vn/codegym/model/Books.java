package vn.codegym.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String subject;

    private String author;

    private String image;

    private Integer quantity;

    @OneToMany(mappedBy = "books")
    private List<BorrowBookCode> bookCodeList;

    public Books() {
    }

    public Books(String title, String subject, String author, String image, Integer quantity) {
        this.title = title;
        this.subject = subject;
        this.author = author;
        this.image = image;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<BorrowBookCode> getBookCodeList() {
        return bookCodeList;
    }

    public void setBookCodeList(List<BorrowBookCode> bookCodeList) {
        this.bookCodeList = bookCodeList;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
