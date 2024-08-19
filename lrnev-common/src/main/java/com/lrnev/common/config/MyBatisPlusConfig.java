package com.lrnev.common.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatisPlus 配置类
 * 使用多个插件时，需要注意它们的顺序。建议的顺序是：
 * 多租户、动态表名
 * 分页、乐观锁
 * SQL 性能规范、防止全表更新与删除
 *
 * @author 鲁子狄
 **/
@Configuration
public class MyBatisPlusConfig {

    // TODO 租户
//    private CustomTenantHandler customTenantHandler;
//
//    /**
//     * 租户插件
//     */
//    @Bean
//    public MybatisPlusInterceptor TenantInterceptor() {
//        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        TenantLineInnerInterceptor tenantInterceptor = new TenantLineInnerInterceptor();
//        tenantInterceptor.setTenantLineHandler(customTenantHandler);
//        interceptor.addInnerInterceptor(tenantInterceptor);
//        return interceptor;
//    }

    /**
     * 添加分页插件
     */
    @Bean
    public MybatisPlusInterceptor paginationInnerInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 如果有多数据源可以不配具体类型, 否则都建议配上具体的 DbType
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }

    /**
     * 乐观锁插件
     */
    @Bean
    public MybatisPlusInterceptor optimisticLocksInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }

    /**
     * 数据变动记录插件
     */
    @Bean
    public MybatisPlusInterceptor operationLogsInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        DataChangeRecorderInnerInterceptor dataChangeRecorderInnerInterceptor = new DataChangeRecorderInnerInterceptor();
        // 配置安全阈值，例如限制批量更新或插入的记录数不超过 1000 条
        dataChangeRecorderInnerInterceptor.setBatchUpdateLimit(1000);
        interceptor.addInnerInterceptor(dataChangeRecorderInnerInterceptor);
        return interceptor;
    }

    /**
     * 防全表更新与删除插件
     */
    @Bean
    public MybatisPlusInterceptor fullTableOperationInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        return interceptor;
    }

    /**
     * 非法SQL拦截插件
     */
    @Bean
    public MybatisPlusInterceptor invalidSqlStatementsInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 添加非法SQL拦截器
        interceptor.addInnerInterceptor(new IllegalSQLInnerInterceptor());
        return interceptor;
    }
}