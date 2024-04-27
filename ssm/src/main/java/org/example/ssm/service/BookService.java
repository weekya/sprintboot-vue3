package org.example.ssm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.ssm.pojo.Book;
import org.example.ssm.pojo.User;

import java.util.List;

public interface BookService extends IService<Book> {

    List<Book> selectAllBook();
    Book selectBookById(int id);
    List<Book> selectBookByTitle(String title);
    List<Book> selectBookByAuthor(String author);
    List<Book> selectBookByIsbn(String isbn);
    List<Book> selectBookByPublisher(String publisher);
    int insertBook(Book book);
    void deleteBook(String isbn);
    void updateBook(Book book);
}
