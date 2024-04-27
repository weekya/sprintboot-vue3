package org.example.ssm.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.ssm.dao.BorrowDao;
import org.example.ssm.pojo.Borrow;
import org.example.ssm.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BorrowServiceImpl extends ServiceImpl<BorrowDao, Borrow> implements BorrowService {

    @Autowired
    BorrowDao borrowDao;


    @Override
    public List<Borrow> selectAllBorrow() {
        return borrowDao.selectAllBorrow();
    }

    @Override
    public int insertBorrow(Borrow borrow) {
        return borrowDao.insertBorrow(borrow);
    }

    @Override
    public void deleteBorrow(int id) {
        borrowDao.deleteBorrow(id);
    }
}
