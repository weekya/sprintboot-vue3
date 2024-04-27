package org.example.ssm.controller;

import jakarta.annotation.Resource;
import org.example.ssm.pojo.Book;
import org.example.ssm.pojo.Borrow;
import org.example.ssm.pojo.User;
import org.example.ssm.service.impl.BookServiceImpl;
import org.example.ssm.service.impl.BorrowServiceImpl;
import org.example.ssm.service.impl.UserServiceImpl;
import org.example.ssm.utils.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow")
public class BorrowController {
    @Resource
    private BorrowServiceImpl borrowService;
    @Resource
    private BookServiceImpl bookService;

    @GetMapping("/allBorrow")
    public Result<List<Borrow>> allBorrowInfo(){
        List<Borrow> borrows = borrowService.selectAllBorrow();
        if(borrows != null){
            return Result.success(borrows, "获取成功");
        }else{
            return Result.error("401","获取失败");
        }
    }

    @PostMapping("/insert")
    public Result<Integer> insertBorrow(@RequestBody Borrow borrow){
        Book book = bookService.selectBookById(borrow.getBookId());
        if(book != null && book.getQuantity() > 0){
            book.setQuantity(book.getQuantity() - 1);
            bookService.updateBook(book);
            int re = borrowService.insertBorrow(borrow);
            return Result.success(re,"成功借阅");
        }else{
            return Result.error("401","借阅失败，库存已无");
        }
    }

    @GetMapping("/delete")
    public Result<List<Borrow>> deleteBorrow(@RequestParam int id){
        System.out.println(id);
        borrowService.deleteBorrow(id);
        List<Borrow> borrows = borrowService.selectAllBorrow();
        if(borrows != null){
            return Result.success(borrows,"归还成功");
        }else{
            return Result.error("401","归还失败");
        }
    }
}
