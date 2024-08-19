package com.lrnev.common.base;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * BaseEntity 是所有实体类的基础类，提供了通用字段，如ID、创建时间和更新时间等。
 *
 * @author 鲁子狄
 **/
@Getter
@Setter
@ToString(exclude = {"remark"})
public class BaseEntity {
    /**
     * 雪花算法Id
     * 使用  @TableId 自定义生成主键值
     * 如果希望使用数据库生成主键值请用 @KeySequence
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 租户ID
     */
    @TableField(fill = FieldFill.INSERT, value = "`tenant_id`")
    private Long tenantId;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private Long creator;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT, value = "`created_at`")
    private LocalDateTime createdAt;

    /**
     * 最后修改人
     */
    @TableField(fill = FieldFill.UPDATE)
    private Long modifier;

    /**
     * 最后修改时间
     */
    @TableField(fill = FieldFill.UPDATE, value = "`modify_at`")
    private LocalDateTime modifyAt;

    /**
     * 乐观锁
     */
    @Version
    private Integer version;

    /**
     * 逻辑删除
     * 0 表示未删除, 1 表示已删除
     */
    @TableLogic
    @TableField(value = "`is_deleted`")
    private Integer deleted;

    /**
     * 备注
     */
    @TableField(value = "`remark`")
    private String remark;
}
