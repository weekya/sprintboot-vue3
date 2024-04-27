package org.example.ssm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.example.ssm.pojo.Borrow;
import org.example.ssm.pojo.User;

import java.util.List;

public interface UserService extends IService<User> {

    User loginService(String email,String password);
    User registerService(User user);

    User selectUserByEmail(String email);
    List<User> selectAllUser();
    int insertUser(User user);

    List<Borrow> selectAllBorrow();

    int insertBorrow(Borrow borrow);

    void deleteBorrow(int id);
}
