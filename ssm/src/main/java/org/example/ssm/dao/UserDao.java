package org.example.ssm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.ssm.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao extends BaseMapper<User> {
    @Select("select * from user where email = #{email}")
    User selectUserByEmail(@Param("email") String email);

    @Select("select * from user where email = #{email} and password = #{password}")
    User loginService(@Param("email") String email, @Param("password") String password);
    @Select("select * from user")
    List<User> selectAllUser();
    @Insert("insert into user (name,password,email,privilege,phone) values(#{name},#{password},#{email},#{privilege},#{phone})")
    int insertUser(User user);
}
