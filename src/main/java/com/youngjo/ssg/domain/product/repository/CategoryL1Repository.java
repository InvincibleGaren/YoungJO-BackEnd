package com.youngjo.ssg.domain.product.repository;

import com.youngjo.ssg.domain.product.domain.CategoryL1;

import java.util.List;

public interface CategoryL1Repository {
    Long save(CategoryL1 ctgL1);

    CategoryL1 findByName(String ctgL1Name);
    CategoryL1 findById(Long id);

    List<CategoryL1> getAllWithL2();

    void addUrl(Long id, String url);

}
