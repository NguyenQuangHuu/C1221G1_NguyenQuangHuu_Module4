package vn.codegym.service;

import vn.codegym.model.Books;
import vn.codegym.model.BorrowBookCode;

public interface IBorrowBookCodeService {

    void save(BorrowBookCode borrowBookCode);

    boolean checkCode(String code);

    BorrowBookCode checkGiveBack(String code);

}
