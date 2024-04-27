package org.example.ssm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.ssm.dao.UserDao;
import org.example.ssm.pojo.Borrow;
import org.example.ssm.pojo.User;
import org.example.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Autowired
    UserDao userDao;


    @Override
    public User loginService(String email, String password) {
        User user = userDao.loginService(email, password);
        return user;
    }

    @Override
    public User registerService(User user) {
        User u = userDao.selectUserByEmail(user.getEmail());
        if(u == null){
            int rs = userDao.insertUser(user);
            return user;
        }else return null;
    }

    @Override
    public User selectUserByEmail(String email) {
        return userDao.selectUserByEmail(email);
    }

    @Override
    public List<User> selectAllUser() {
        return userDao.selectAllUser();
    }

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public List<Borrow> selectAllBorrow() {
        return null;
    }

    @Override
    public int insertBorrow(Borrow borrow) {
        return 0;
    }

    @Override
    public void deleteBorrow(int id) {

    }

}
