package org.example.ssm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.ssm.dao.BookDao;
import org.example.ssm.dao.UserDao;
import org.example.ssm.pojo.Book;
import org.example.ssm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements BookService {
    @Autowired
    BookDao bookDao;


    @Override
    public List<Book> selectAllBook() {
        return bookDao.selectAllBook();
    }

    @Override
    public Book selectBookById(int id) {
        return bookDao.selectBookById(id);
    }

    @Override
    public List<Book> selectBookByTitle(String title) {

        return bookDao.selectBookByTitle(title);
    }

    @Override
    public List<Book> selectBookByAuthor(String author) {

        return bookDao.selectBookByAuthor(author);
    }

    @Override
    public List<Book> selectBookByIsbn(String isbn) {

        return bookDao.selectBookByIsbn(isbn);
    }

    @Override
    public List<Book> selectBookByPublisher(String publisher) {

        return bookDao.selectBookByPublisher(publisher);
    }

    @Override
    public int insertBook(Book book) {
        return bookDao.insertBook(book);
    }

    @Override
    public void deleteBook(String isbn) {

        bookDao.deleteBook(isbn);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

}
