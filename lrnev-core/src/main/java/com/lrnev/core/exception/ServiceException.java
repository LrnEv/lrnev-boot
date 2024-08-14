package com.lrnev.core.exception;

import com.github.lrnev.exception.enums.ServiceErrorEnum;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;

/**
 * 业务异常类
 *
 * @author 鲁子狄
 **/
@Getter
public class ServiceException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 301992150974732392L;

    private final Integer code;

    /**
     * 使用已有的错误类型
     *
     * @param errorEnum 业务异常错误枚举
     */
    public ServiceException(@NotNull ServiceErrorEnum errorEnum) {
        super(errorEnum.getMessage());
        code = errorEnum.getCode();
    }

    /**
     * 使用已有数据类型并拼接错误信息
     *
     * @param errorEnum 业务异常错误枚举
     * @param message   错误信息
     */
    public ServiceException(@NotNull ServiceErrorEnum errorEnum, String message) {
        super(String.format("%s %s", errorEnum.getMessage(), message));
        code = errorEnum.getCode();
    }

    /**
     * 自定义错误类型, 枚举中没有的错误类型
     *
     * @param code    自定义错误码
     * @param message 自定义错误信息
     */
    public ServiceException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 指定错误类型，一般为业务提示
     *
     * @param message 自定义错误信息
     */
    public ServiceException(String message) {
        super(message);
        code = ServiceErrorEnum.BUSINESS_HINT.getCode();
    }
}
