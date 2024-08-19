package com.lrnev.rbac.model;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lrnev.common.base.BaseEntity;
import com.lrnev.rbac.enums.AccountStatusEnum;

import java.time.LocalDateTime;

/**
 * 账号 Entity
 *
 * @author 鲁子狄
 **/
@TableName("`account`")
public class AccountEntity extends BaseEntity {

    /**
     * 用户名
     */
    @TableField(value = "`user_name`")
    private String userName;

    /**
     * 密码(应进行加密)
     */
    @TableField(value = "`password`")
    private String password;

    /**
     * 账户状态
     */
    @TableField(value = "`status`")
    private AccountStatusEnum status;

    /**
     * 最后登录时间
     */
    @TableField(value = "`last_login_at`")
    private LocalDateTime lastLoginAt;

    /**
     * 电子邮件
     */
    @TableField(value = "`email`")
    private String email;

    /**
     * 电话号码
     */
    @TableField(value = "`phone_number`")
    private String phoneNumber;

    /**
     * 真实姓名
     */
    @TableField(value = "`real_name`")
    private String realName;

    /**
     * 头像 URL
     */
    @TableField(value = "`avatar`")
    private String avatar;

    /**
     * 失败登录次数
     */
    @TableField(value = "`failed_login_attempts`")
    private int failedLoginAttempts;
}