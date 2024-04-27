package org.example.ssm.controller;

import jakarta.annotation.Resource;
import org.example.ssm.pojo.Book;
import org.example.ssm.pojo.Borrow;
import org.example.ssm.pojo.User;
import org.example.ssm.service.BookService;
import org.example.ssm.service.BorrowService;
import org.example.ssm.service.UserService;
import org.example.ssm.service.impl.BookServiceImpl;
import org.example.ssm.service.impl.BorrowServiceImpl;
import org.example.ssm.service.impl.UserServiceImpl;
import org.example.ssm.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private UserServiceImpl userService;
    @Resource
    private BorrowServiceImpl borrowService;

    @PostMapping("/user/Login")
    public Result<String> login(@RequestBody User loginUser){
        System.out.println(loginUser.getEmail() + " " + loginUser.getPassword());
        return Result.success("200","登录成功");

    }

    @PostMapping("/user/Register")
    public Result<String> registerController(@RequestBody User newUser){
        System.out.println(newUser);
        return Result.success("200","通过");
    }

    @Resource
    private BookService bookService;

    @GetMapping("/book")
    public Result<List<Book>> allBook(){
        return Result.success(bookService.selectAllBook(),"通过");
    }


    @GetMapping("/book/findByTitle")
    public Result<List<Book>> findBookTitle(@RequestParam String title){
        return Result.success(bookService.selectAllBook(),"通过");
    }
    @GetMapping("/book/findByAuthor")
    public Result<List<Book>> findBookAuthor(@RequestParam String author){

        return Result.success(bookService.selectAllBook(),"通过");
    }
    @GetMapping("/book/findByIsbn")
    public Result<List<Book>> findBookIsbn(@RequestParam String isbn){

        return Result.success(bookService.selectAllBook(),"通过");
    }
    @GetMapping("/book/findByPublisher")
    public Result<List<Book>> findBookPublisher(@RequestParam String publisher){
        return Result.success(bookService.selectAllBook(),"通过");
    }
    @PostMapping("/book/insert")
    public Result<String> insertBook(@RequestBody Book book){
        return Result.success("200","通过");
    }
    @PostMapping("/book/update")
    public Result<String> updateBook(@RequestBody Book book){
        return Result.success("200","通过");
    }
    @GetMapping("/book/delete")
    public Result<String> deleteBook(@RequestParam String isbn) {
        return Result.success("200","通过");
    }
    @GetMapping("/borrow/allBorrow")
    public Result<List<Borrow>> allBorrowInfo(){
        List<Borrow> borrows = borrowService.selectAllBorrow();
        return Result.success(borrows,"通过");
    }

    @PostMapping("/borrow/insert")
    public Result<List<Borrow>> insertBorrow(@RequestBody Borrow borrow){
        List<Borrow> borrows = borrowService.selectAllBorrow();
        return Result.success(borrows,"通过");
    }

    @GetMapping("/borrow/delete")
    public Result<List<Borrow>> deleteBorrow(@RequestParam int id){
        List<Borrow> borrows = borrowService.selectAllBorrow();
        return Result.success(borrows,"通过");
    }
}
