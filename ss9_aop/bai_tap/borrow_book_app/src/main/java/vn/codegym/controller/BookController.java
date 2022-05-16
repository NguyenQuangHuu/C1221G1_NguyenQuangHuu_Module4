package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Books;
import vn.codegym.model.BorrowBookCode;
import vn.codegym.service.IBookService;
import vn.codegym.service.IBorrowBookCodeService;

import java.time.LocalDate;


@Controller
public class BookController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private IBorrowBookCodeService borrowBookCodeService;

    @GetMapping("/")
    public String getAll(@PageableDefault(value = 10) Pageable pageable, Model model){
        Page<Books> books = this.bookService.getAll(pageable);
        model.addAttribute("books",books);
        return "list";
    }

    @GetMapping("/detail/{id}")
    public String getDetail(@PathVariable Integer id,Model model){
        Books book = this.bookService.getOne(id);
        if(book==null){
            return "not_found";
        }else{
            model.addAttribute("book",book);
            return "detail";
        }
    }

    @GetMapping("/borrow/{id}")
    public String borrowBook(@PathVariable Integer id, RedirectAttributes redirectAttributes) throws Exception {
        Books book = this.bookService.getOne(id);
        if(book==null){
            return "not_found";
        }else if(book.getQuantity() <= 0){
            throw new Exception("Không tồn tại sách này");
//            redirectAttributes.addFlashAttribute("code","Số lượng sách trong kho đã hết, vui lòng chọn sách khác");
//            return "redirect:/";
        } else{
            BorrowBookCode bookCode = new BorrowBookCode();
            bookCode.setBooks(book);
            book.setQuantity(book.getQuantity()-1);

            this.bookService.save(book);
            this.borrowBookCodeService.save(bookCode);
            redirectAttributes.addFlashAttribute("code","Mã mượn sách của bạn là :"+bookCode.getCode()+" ,vui lòng lưu giữ để trả sách.");
            return "redirect:/";
        }
    }

    @GetMapping("/give-back")
    public String giveBackBook(@RequestParam String code,RedirectAttributes redirectAttributes) throws Exception {
        BorrowBookCode borrowBookCode =  this.borrowBookCodeService.checkGiveBack(code);
        if(borrowBookCode == null || borrowBookCode.getCode().equals("")){
            throw new Exception("Không tồn tại sách này");
        }else if(borrowBookCode.isGiveBack()){
            redirectAttributes.addFlashAttribute("code","Mã mượn sách này đã trả sách rồi, vui lòng nhập mã khác");
            return "redirect:/";
        } else{
            borrowBookCode.setGiveBack(true);
            borrowBookCode.getBooks().setQuantity(borrowBookCode.getBooks().getQuantity()+1);
            this.borrowBookCodeService.save(borrowBookCode);
            this.bookService.save(borrowBookCode.getBooks());
            return "redirect:/";
        }
    }

    @ExceptionHandler(Exception.class)
    public String handlerException(){
        return "not_found";
    }

}
