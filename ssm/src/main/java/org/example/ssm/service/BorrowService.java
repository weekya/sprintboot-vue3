package org.example.ssm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.ssm.pojo.Borrow;
import org.example.ssm.pojo.User;

import java.util.List;

public interface BorrowService extends IService<Borrow> {

    List<Borrow> selectAllBorrow();
    int insertBorrow(Borrow borrow);
    void deleteBorrow(int id);

}