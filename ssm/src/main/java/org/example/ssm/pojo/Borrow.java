package org.example.ssm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("borrow")
@Repository
public class Borrow implements Serializable {
    @TableId(type = IdType.AUTO)
    private int id;
    private int bookId;
    private int userId;
    private String bookTitle;
    private String userName;
    private Date borrowDate;

}
