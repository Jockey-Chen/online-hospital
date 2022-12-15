package com.jockey.onlineHospital.beans;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String sex;
    private String email;
    @TableField(fill = FieldFill.INSERT)    //表示进行insert操作时自动填充该字段
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.UPDATE)    //表示进行update操作时自动填充该字段
    private LocalDateTime updateTime;
    @Version    //乐观锁版本号
    @TableField(fill = FieldFill.INSERT)    //创建字段时自动填充初始版本号
    private Integer version;
    @TableLogic     //逻辑删除，标记为0表示不删除，标记为1表示删除。标记为逻辑删除的数据，在数据库中仍然存在，但mybatis查询不到
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;

    public User(Integer id, String username, String password, Integer age, String sex, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.email = email;
    }
}
