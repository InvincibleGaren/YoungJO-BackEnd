package com.youngjo.ssg.domain.product.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youngjo.ssg.domain.product.domain.common.Category;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class CategoryL4 extends Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_l4_id")
    private Long id;
    private String name;

    //==매핑==
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_l3_id")
    private CategoryL3 categoryL3;

    @JsonIgnore
    @OneToMany(mappedBy = "categoryL4", fetch = FetchType.LAZY)
    private List<ProductBoard> productBoardList = new ArrayList<>();

    @Builder
    public CategoryL4(String name, CategoryL3 categoryL3, List<ProductBoard> productBoardList) {
        this.name = name;
        this.categoryL3 = categoryL3;
        this.productBoardList = productBoardList;
    }

    public void linkToProductBoard(ProductBoard board) {
        this.productBoardList.add(board);
    }

    public void linkToCategoryL3(CategoryL3 categoryL3) {
        this.categoryL3 = categoryL3;
        categoryL3.linkToCategoryL4(this);
    }
}
