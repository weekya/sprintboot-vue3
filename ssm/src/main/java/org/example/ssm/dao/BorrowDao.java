package org.example.ssm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.example.ssm.pojo.Borrow;
import org.example.ssm.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BorrowDao extends BaseMapper<Borrow> {
    @Select("select * from borrow")
    List<Borrow> selectAllBorrow();
    @Insert("insert into borrow (bookId, userId,bookTitle,userName,borrowDate) values(#{bookId},#{userId},#{bookTitle},#{userName},#{borrowDate})")
    int insertBorrow(Borrow borrow);

    @Delete("delete from borrow where id = #{id}")
    void deleteBorrow(@Param("id") int id);
}