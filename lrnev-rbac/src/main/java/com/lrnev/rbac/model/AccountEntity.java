package com.lrnev.rbac.model;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lrnev.common.base.BaseEntity;

import java.time.LocalDateTime;

/**
 * 账号 Entity
 *
 * @author 鲁子狄
 **/
@TableName("`sys_user`")
public class AccountEntity extends BaseEntity {
    @TableField(fill = FieldFill.INSERT, value = "`tenant_id`")
    private String username;


    private String password;

//    private AccountStatus status;


    private LocalDateTime lastLoginAt;

    private String email;

    private String phoneNumber;
}