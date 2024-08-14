package com.lrnev.core.exception;

import com.github.lrnev.rest.response.ResponseResult;
import com.github.lrnev.rest.response.enums.HttpStatusEnum;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.Serial;
import java.nio.file.AccessDeniedException;

/**
 * 全局异常处理器
 *
 * @author 鲁子狄
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends Exception {

    @Serial
    private static final long serialVersionUID = -2324258151049296890L;

    /**
     * 权限校验异常
     */
    @ExceptionHandler(AccessDeniedException.class)
    public <T> ResponseResult<T> handleAccessDeniedException(@NotNull AccessDeniedException e, @NotNull HttpServletRequest request) {
        String requestUrl = request.getRequestURI();
        log.error("请求地址'{}',权限校验失败: {}", requestUrl, e.getMessage());
        return ResponseResult.fail(HttpStatusEnum.FORBIDDEN.getCode(), HttpStatusEnum.FORBIDDEN.getMessage());
    }

    /**
     * 请求方式不支持
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public <T> ResponseResult<T> handleHttpRequestMethodNotSupported(@NotNull HttpRequestMethodNotSupportedException e, @NotNull HttpServletRequest request) {
        String requestUrl = request.getRequestURI();
        log.error("请求地址'{}',不支持的请求方法: {}", requestUrl, e.getMethod());
        return ResponseResult.fail(e.getMessage());
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(ServiceException.class)
    public <T> ResponseResult<T> handleServiceException(ServiceException e) {
        log.error("业务异常: {}", e.getMessage(), e);
        Integer code = e.getCode();
        return ObjectUtils.isNotEmpty(code) ? ResponseResult.fail(code, e.getMessage()) : ResponseResult.fail(e.getMessage());
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public <T> ResponseResult<T> handleRuntimeException(RuntimeException e, @NotNull HttpServletRequest request) {
        String requestUrl = request.getRequestURI();
        log.error("请求地址'{}',发生未知异常: {}", requestUrl, e.getMessage(), e);
        return ResponseResult.fail(e.getMessage());
    }

    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public <T> ResponseResult<T> handleException(Exception e, @NotNull HttpServletRequest request) {
        String requestUrl = request.getRequestURI();
        log.error("请求地址'{}',发生系统异常: {}", requestUrl, e.getMessage(), e);
        return ResponseResult.fail(e.getMessage());
    }

    /**
     * 自定义验证异常
     */
    @ExceptionHandler(BindException.class)
    public <T> ResponseResult<T> handleBindException(BindException e) {
        log.error("验证异常: {}", e.getMessage(), e);
        String message = e.getAllErrors().stream()
                .findFirst()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .orElse(e.getMessage());
        return ResponseResult.fail(HttpStatusEnum.BAD_REQUEST.getCode(), message);
    }

    /**
     * 自定义验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public <T> ResponseResult<T> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("验证异常: {}", e.getMessage(), e);
        String message = e.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .orElse(e.getMessage());
        return ResponseResult.fail(HttpStatusEnum.BAD_REQUEST.getCode(), message);
    }
}
