package com.lrnev.common.base;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 基础映射接口，提供了从 DTO 到 Entity 及反向转换的方法。
 *
 * @param <D> DTO 类型
 * @param <E> Entity 类型
 * @author 鲁子狄
 */
public interface BaseConvert<D, E> {
    /**
     * 将 DTO 转换为 Entity。
     *
     * @param dto DTO 对象
     * @return 转换后的 Entity 对象
     */
    E toEntity(D dto);

    /**
     * 将 Entity 转换为 DTO。
     *
     * @param entity Entity 对象
     * @return 转换后的 DTO 对象
     */
    D toDto(E entity);

    /**
     * 将 DTO 列表转换为 Entity 列表。
     *
     * @param dtoList DTO 对象列表
     * @return 转换后的 Entity 对象列表
     */
    List<E> toEntityList(List<D> dtoList);

    /**
     * 将 Entity 列表转换为 DTO 列表。
     *
     * @param entityList Entity 对象列表
     * @return 转换后的 DTO 对象列表
     */
    List<D> toDtoList(List<E> entityList);

    /**
     * 将 Entity 的分页结果转换为 DTO 的分页结果。
     *
     * @param pageEntity Entity 的分页结果
     * @return 转换后的 DTO 分页结果
     */
    Page<D> toPageDto(Page<E> pageEntity);
}