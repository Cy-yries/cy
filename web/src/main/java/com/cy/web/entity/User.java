package com.cy.web.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName User
 * @Author Yin
 * @Date 2020/10/4 17:29
 * @Version 1.0
 **/
@Data
@Accessors(chain = true)
@TableName("cy_user")
public class User {
    private String id;
    private String nickname;
    private String account;
    private String password;
    @TableField("headImg")
    private String headImg;
    private String level;
}
