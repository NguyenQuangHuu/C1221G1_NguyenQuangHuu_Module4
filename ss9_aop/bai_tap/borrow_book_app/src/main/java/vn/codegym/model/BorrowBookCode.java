package vn.codegym.model;

import javax.persistence.*;

@Entity
public class BorrowBookCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    @Column(columnDefinition = "DATE")
    private String borrowStartDate;

    @Column(columnDefinition = "BIT")
    private boolean giveBack;

    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Books books;

    public BorrowBookCode() {
        this.giveBack = false;
    }

    public BorrowBookCode(String code, String borrowStartDate, Books books) {
        this.code = code;
        this.borrowStartDate = borrowStartDate;
        this.giveBack = false;
        this.books = books;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBorrowStartDate() {
        return borrowStartDate;
    }

    public void setBorrowStartDate(String borrowStartDate) {
        this.borrowStartDate = borrowStartDate;
    }

    public boolean isGiveBack() {
        return giveBack;
    }

    public void setGiveBack(boolean giveBack) {
        this.giveBack = giveBack;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }


}
