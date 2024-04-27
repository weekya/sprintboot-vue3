package org.example.ssm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
@Repository
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    private int id;

    private String name;
    private String password;
    private String email;
    private boolean privilege;
    private String phone;
}
