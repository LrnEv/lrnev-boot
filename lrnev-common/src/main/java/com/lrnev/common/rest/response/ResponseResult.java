package com.lrnev.common.rest.response;

import com.lrnev.common.enums.HttpStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

/**
 * 统一结果集处理器
 *
 * @author 鲁子狄
 **/
@Getter
@Setter
@ToString
@Schema(description = "统一结果集处理器")
public class ResponseResult<T> {

    /**
     * 状态码
     */
    @Schema(name = "code", description = "状态码")
    private Integer code;

    /**
     * 状态信息
     */
    @Schema(name = "state", description = "状态信息")
    private Boolean state;

    /**
     * 返回信息
     */
    @Schema(name = "message", description = "返回信息")
    private String message;

    /**
     * 数据
     */
    @Schema(description = "数据")
    private T data;


    /**
     * response 全参数方法
     *
     * @param code    状态码
     * @param state   状态信息
     * @param message 返回信息
     * @param data    数据
     * @return {@link ResponseResult <T>}
     */
    @NotNull
    private static <T> ResponseResult<T> response(Integer code, Boolean state, String message, T data) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setCode(code);
        responseResult.setState(state);
        responseResult.setMessage(message);
        responseResult.setData(data);
        return responseResult;
    }

    /**
     * response 全参数方法
     *
     * @param code    状态码
     * @param state   状态信息
     * @param message 返回信息
     * @return {@link ResponseResult <T>}
     */
    @NotNull
    private static <T> ResponseResult<T> response(Integer code, Boolean state, String message) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setCode(code);
        responseResult.setState(state);
        responseResult.setMessage(message);
        return responseResult;
    }

    /**
     * success 成功返回（无参）
     *
     * @return {@link ResponseResult<T>}
     */
    @NotNull
    public static <T> ResponseResult<T> success() {
        return response(HttpStatusEnum.SUCCESS.getCode(), true, HttpStatusEnum.SUCCESS.getMessage(), null);
    }

    /**
     * success 成功返回（枚举参数）
     *
     * @param httpResponseEnum 枚举参数
     * @return {@link ResponseResult<T>}
     */
    @NotNull
    public static <T> ResponseResult<T> success(@NotNull HttpStatusEnum httpResponseEnum) {
        return response(httpResponseEnum.getCode(), true, httpResponseEnum.getMessage());
    }

    /**
     * success 成功返回(状态码+返回信息)
     *
     * @param code    状态码
     * @param message 返回信息
     * @return {@link ResponseResult<T>}
     */
    @NotNull
    public static <T> ResponseResult<T> success(Integer code, String message) {
        return response(code, true, message);
    }

    /**
     * success 成功返回(返回信息+数据)
     *
     * @param message 返回信息
     * @param data    数据
     * @return {@link ResponseResult<T>}
     */
    @NotNull
    public static <T> ResponseResult<T> success(String message, T data) {
        return response(HttpStatusEnum.SUCCESS.getCode(), true, message, data);
    }

    /**
     * success 成功返回(状态码+返回信息+数据)
     *
     * @param code    状态码
     * @param message 返回信息
     * @param data    数据
     * @return {@link ResponseResult<T>}
     */
    @NotNull
    public static <T> ResponseResult<T> success(Integer code, String message, T data) {
        return response(code, true, message, data);
    }

    /**
     * success 成功返回(数据)
     *
     * @param data 数据
     * @return {@link ResponseResult<T>}
     */
    @NotNull
    public static <T> ResponseResult<T> success(T data) {
        return response(HttpStatusEnum.SUCCESS.getCode(), true, HttpStatusEnum.SUCCESS.getMessage(), data);
    }

    /**
     * success 成功返回(返回信息)
     *
     * @param message 返回信息
     * @return {@link ResponseResult<T>}
     */
    @NotNull
    public static <T> ResponseResult<T> success(String message) {
        return response(HttpStatusEnum.SUCCESS.getCode(), true, message, null);
    }

    /**
     * fail 失败返回(无参)
     *
     * @return {@link ResponseResult<T>}
     */
    @NotNull
    public static <T> ResponseResult<T> fail() {
        return response(HttpStatusEnum.ERROR.getCode(), false, HttpStatusEnum.ERROR.getMessage(), null);
    }

    /**
     * fail 失败返回(枚举)
     *
     * @param httpResponseEnum 枚举
     * @return {@link ResponseResult<T>}
     */
    @NotNull
    public static <T> ResponseResult<T> fail(@NotNull HttpStatusEnum httpResponseEnum) {
        return response(httpResponseEnum.getCode(), false, httpResponseEnum.getMessage());
    }

    /**
     * fail 失败返回(状态码+返回信息)
     *
     * @param code    状态码
     * @param message 返回信息
     * @return {@link ResponseResult<T>}
     */
    @NotNull
    public static <T> ResponseResult<T> fail(Integer code, String message) {
        return response(code, false, message);
    }

    /**
     * fail 失败返回(返回信息+数据)
     *
     * @param message 返回信息
     * @param data    数据
     * @return {@link ResponseResult<T>}
     */
    @NotNull
    public static <T> ResponseResult<T> fail(String message, T data) {
        return response(HttpStatusEnum.ERROR.getCode(), false, message, data);
    }

    /**
     * fail 失败返回(状态码+返回信息+数据)
     *
     * @param code    状态码
     * @param message 返回消息
     * @param data    数据
     * @return {@link ResponseResult<T>}
     */
    @NotNull
    public static <T> ResponseResult<T> fail(Integer code, String message, T data) {
        return response(code, false, message, data);
    }

    /**
     * fail 失败返回(状态码+返回信息)
     *
     * @param httpResponseEnum 枚举
     * @param message          返回消息
     * @return {@link ResponseResult<T>}
     */
    @NotNull
    public static <T> ResponseResult<T> fail(@NotNull HttpStatusEnum httpResponseEnum, String message) {
        return response(httpResponseEnum.getCode(), false, message);
    }

    /**
     * fail 失败返回（数据）
     *
     * @param data 数据
     * @return {@link ResponseResult<T>}
     */
    @NotNull
    public static <T> ResponseResult<T> fail(T data) {
        return response(HttpStatusEnum.ERROR.getCode(), false, HttpStatusEnum.ERROR.getMessage(), data);
    }

    /**
     * fail 失败返回(返回信息)
     *
     * @param message 返回信息
     * @return {@link ResponseResult<T>}
     */
    @NotNull
    public static <T> ResponseResult<T> fail(String message) {
        return response(HttpStatusEnum.ERROR.getCode(), false, message, null);
    }
}
