package com.youngjo.ssg.domain.product.dto.request;

import com.youngjo.ssg.domain.product.domain.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@NoArgsConstructor
public class AddPdtBoardReqDto {
    @NotBlank
    private String title;
    @NotBlank
    private String brand;
    @NotBlank
    private String salesSite;
    private List<Tag> tagList;
    // == ShippingInfo ==
    private Boolean isEachShippingFee;
    private Boolean isPremium;
    private Boolean isCrossBorderShipping;
    private Boolean isOnlineOnly;

    private Integer shippingFee;
    private Integer shippingFreeOver;
    private Boolean availableDeliveryJeju;
    private Boolean availableDeliveryIsland;
    private Integer shippingFeeJeju;
    private Integer shippingFeeIsland;

    private String courierCompany;

    // Product Detail Information
    private String pdtName;

    private List<ProductRequiredInfo> requiredInfoList;

    // == Exchange Refund ==
    private Address returnAddress;
    private Integer exchangeShippingFee;
    private Integer returnShippingFee;
    private Integer premiumExchangeShippingFee;
    private Integer premiumReturnShippingFee;

    private ConsignmentSellerInfo consignmentSellerInfo;
    // == Mapping ==
    @NotBlank
    private Long ctgL4Id;
    private List<ProductImg> thumbImgList;
    private List<ProductImg> detailImgList;
    private List<MainProduct> mainProductList;
}