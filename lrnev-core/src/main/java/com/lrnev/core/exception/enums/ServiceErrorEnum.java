package com.lrnev.core.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 业务异常错误枚举
 * 定义了各种业务异常对应的错误码及错误信息。
 *
 * @author 鲁子狄
 **/
@Getter
@AllArgsConstructor
public enum ServiceErrorEnum {
    /**
     * 用户未登录。
     */
    USER_NOT_LOGGED_IN(10001, "用户未登录"),

    /**
     * 参数不正确。
     */
    INVALID_PARAMETERS(10002, "参数不正确"),

    /**
     * 记录不存在。
     */
    RECORD_NOT_FOUND(10003, "记录不存在"),

    /**
     * 用户名或密码错误。
     */
    INVALID_CREDENTIALS(10004, "用户名或密码错误"),

    /**
     * 资源已被占用。
     */
    RESOURCE_OCCUPIED(10005, "资源已被占用"),

    /**
     * 操作失败。
     */
    OPERATION_FAILED(10006, "操作失败"),

    /**
     * 权限不足。
     */
    INSUFFICIENT_PERMISSION(10007, "权限不足"),

    /**
     * 文件上传失败。
     */
    FILE_UPLOAD_FAILED(10008, "文件上传失败"),

    /**
     * 文件下载失败。
     */
    FILE_DOWNLOAD_FAILED(10009, "文件下载失败"),

    /**
     * 外部服务调用失败。
     */
    EXTERNAL_SERVICE_CALL_FAILED(10010, "外部服务调用失败"),

    /**
     * 数据校验失败。
     */
    DATA_VALIDATION_FAILED(10011, "数据校验失败"),

    /**
     * 会话已过期。
     */
    SESSION_EXPIRED(10012, "会话已过期"),

    /**
     * 业务提示。
     */
    BUSINESS_HINT(11000, "业务提示");

    /**
     * 错误码
     */
    private final int code;

    /**
     * 提示信息
     */
    private final String message;
}