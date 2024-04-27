package org.example.ssm.controller;

import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Delete;
import org.example.ssm.pojo.Book;
import org.example.ssm.service.BookService;
import org.example.ssm.utils.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Resource
    private BookService bookService;

    @GetMapping("")
    public Result<List<Book>> allBook(){
        System.out.println("book");
        return Result.success(bookService.selectAllBook(),"图书信息");
    }

    @GetMapping("/findByTitle")
    public Result<List<Book>> findBookTitle(@RequestParam String title){
        return Result.success(bookService.selectBookByTitle(title),"查找成功");
    }
    @GetMapping("/findByAuthor")
    public Result<List<Book>> findBookAuthor(@RequestParam String author){
        return Result.success(bookService.selectBookByAuthor(author),"查找成功");
    }
    @GetMapping("/findByIsbn")
    public Result<List<Book>> findBookIsbn(@RequestParam String isbn){
        return Result.success(bookService.selectBookByIsbn(isbn),"查找成功");
    }
    @GetMapping("/findByPublisher")
    public Result<List<Book>> findBookPublisher(@RequestParam String publisher){
        return Result.success(bookService.selectBookByPublisher(publisher),"查找成功");
    }
    @PostMapping("/insert")
    public Result insertBook(@RequestBody Book book){
        List<Book> bookList = bookService.selectBookByIsbn(book.getIsbn());
        if(bookList != null && bookList.size() == 0){
            int re = bookService.insertBook(book);
            return Result.success("添加图书成功");
        }else return Result.error("401","插入失败,该书已存在");
    }
    @PostMapping("/update")
    public Result updateBook(@RequestBody Book book){
        List<Book> bookList = bookService.selectBookByIsbn(book.getIsbn());
        if(bookList != null && bookList.size() == 0){
            return Result.error("401","更新失败,该书不存在");
        }else{
            bookService.updateBook(book);
            return Result.success("更新图书成功");
        }
    }
    @GetMapping("/delete")
    public Result deleteBook(@RequestParam String isbn){
        List<Book> bookList = bookService.selectBookByIsbn(isbn);
        if(bookList != null && bookList.size() == 0){
            return Result.error("401","删除失败，该书不存在");
        }else{
            bookService.deleteBook(isbn);
            return Result.success("删除成功");
        }
    }


}
