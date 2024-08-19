package com.lrnev.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 创建一个类来实现 MetaObjectHandler 接口，并重写 insertFill 和 updateFill 方法。
 *
 * @author 鲁子狄
 **/
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 获取当前时间
     *
     * @return 当前时间
     */
    private static @NotNull LocalDateTime getTime() {
        return LocalDateTime.now();
    }

    /**
     * 填充策略-插入
     *
     * @param metaObject MetaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        strictInsertFill(metaObject, "tenantId", Long.class, 0L);
        strictInsertFill(metaObject, "creator", Long.class, 0L);
        strictInsertFill(metaObject, "createdAt", LocalDateTime.class, getTime());
    }

    /**
     * 填充策略-更新
     *
     * @param metaObject MetaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        strictUpdateFill(metaObject, "modifier", Long.class, 0L);
        strictUpdateFill(metaObject, "modifyAt", LocalDateTime.class, getTime());
    }
}