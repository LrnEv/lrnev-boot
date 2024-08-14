package com.lrnev.core.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * dto 基类
 *
 * @author 鲁子狄
 **/
@Getter
@Setter
@ToString
public class BaseDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 7252078909694082852L;
    /**
     * 雪花算法Id
     */
    @Schema(name = "id", description = "主键 Id")
    private Long id;

    /**
     * 备注
     */
    @Schema(name = "remark", description = "备注")
    private String remark;
}