package org.example.ssm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.Data;
import org.apache.ibatis.annotations.*;
import org.example.ssm.pojo.Book;
import org.example.ssm.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface BookDao extends BaseMapper<Book> {
    @Select("select * from book")
    List<Book> selectAllBook();
    @Select("select * from book where id = #{id}")
    Book selectBookById(@Param("id") int id);
    @Select("select * from book where title = #{title}")
    List<Book> selectBookByTitle(@Param("title") String title);

    @Select("select * from book where author = #{author}")
    List<Book> selectBookByAuthor(@Param("author") String author);

    @Select("select * from book where isbn = #{isbn}")
    List<Book> selectBookByIsbn(@Param("isbn") String isbn);

    @Select("select * from book where publisher = #{publisher}")
    List<Book> selectBookByPublisher(@Param("publisher") String publisher);

    @Insert("insert into book (title,author,publisher,category,isbn,quantity) values(#{title},#{author},#{publisher},#{category},#{isbn},#{quantity} )")
    int insertBook(Book book);

    @Delete("delete from book where isbn = #{isbn}")
    void deleteBook(@Param("isbn") String isbn);

    @Update("update book set title = #{title},author=#{author},publisher = #{publisher},category = #{category}, quantity = #{quantity} where isbn = #{isbn}")
    void updateBook(Book book);
}

