package com.youngjo.ssg.domain.product.repository;

import com.youngjo.ssg.domain.product.domain.MainProduct;
import com.youngjo.ssg.domain.product.domain.ProductBoard;
import com.youngjo.ssg.domain.product.domain.ProductBoardLike;
import com.youngjo.ssg.global.common.BaseEntity;

import java.util.List;
import java.util.Map;

public interface ProductRepository {
    // == service code ==
    <T extends BaseEntity> void save(T entity);

    Map<Long, MainProduct> findAllMainPdtMapByIds(List<Long> pdtIds);

    List<MainProduct> findAllMainPdtByIds(List<Long> pdtIds);

    Map<Long, ProductBoard> findAllBoardMapByPdtIds(List<Long> pdtIds);

    List<ProductBoard> findAllBoardByPdtIds(List<Long> pdtIds);

    ProductBoard findBoardById(Long id);

    ProductBoardLike findBoardLikeByBoardIdAndUserId(Long boardId, Long userId);

    Map<Long, Boolean> findBoardLikeMapByBoardIdAndUserId(List<Long> boardIds, Long userId);

    List<ProductBoard> findBoardListByL2Id(Long id, Integer offset, Integer limit, String sort, Long minPrice, Long maxPrice);

    List<ProductBoard> findBoardListByL3Id(Long id, Integer offset, Integer limit, String sort, Long minPrice, Long maxPrice);

    List<ProductBoard> findBoardListByL4Id(Long id, Integer offset, Integer limit, String sort, Long minPrice, Long maxPrice);

    List<ProductBoard> findAllBoardByQuery(String query, Integer offset, Integer limit, String sort, Long minPrice, Long maxPrice);

    MainProduct findMainProductById(Long id);
}
