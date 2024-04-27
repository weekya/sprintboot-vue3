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

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("book")
@Repository
public class Book implements Serializable {
    @TableId(type = IdType.AUTO)
    private int id;
    private String title;
    private String author;
    private String publisher;
    private String category;
    private String isbn;
    private int quantity;

}
