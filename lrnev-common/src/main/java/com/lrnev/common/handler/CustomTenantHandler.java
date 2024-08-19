package com.lrnev.common.handler;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.springframework.stereotype.Component;

/**
 * 租户处理器
 *
 * @author 鲁子狄
 **/
@Component
public class CustomTenantHandler implements TenantLineHandler {

    @Override
    public Expression getTenantId() {
        // 假设有一个租户上下文，能够从中获取当前用户的租户
        // TODO : 租户待添加
//        Long tenantId = TenantContextHolder.getCurrentTenantId();
        Long tenantId = 0L;
        // 返回租户ID的表达式，LongValue 是 JSQLParser 中表示 bigint 类型的 class
        return new LongValue(tenantId);
    }

    @Override
    public String getTenantIdColumn() {
        return "tenant_id";
    }

    @Override
    public boolean ignoreTable(String tableName) {
        // 根据需要返回是否忽略该表
        return false;
    }

}