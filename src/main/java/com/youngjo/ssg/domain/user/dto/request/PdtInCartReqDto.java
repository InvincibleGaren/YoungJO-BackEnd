package com.youngjo.ssg.domain.user.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Positive;

@Getter
@NoArgsConstructor
public class PdtInCartReqDto {
    @Positive
    private Long pdtId;
    @Positive
    private Integer pdtQty;
}
