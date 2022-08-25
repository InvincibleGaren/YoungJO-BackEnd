package com.youngjo.ssg.domain.product.dto.response;

import com.youngjo.ssg.domain.product.domain.ProductBoard;
import com.youngjo.ssg.domain.product.dto.PdtStaticDto;
import com.youngjo.ssg.global.common.AddressConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class PdtBoardDetailResDto {
    private Long boardId;
    private String title;
    private String brand;
    private String salesSite;

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

    private String pdtName;

    private String returnAddress;
    private Integer exchangeShippingFee;
    private Integer returnShippingFee;
    private Integer premiumExchangeShippingFee;
    private Integer premiumReturnShippingFee;

    private Integer totalReviewQty;
    private Integer totalScore;
    private Boolean isSamePrice;
    private Long minPrice;
    private Integer salesVol;
    private Long deliveryDate;

    private PdtStaticDto.ConsignmentSellerInfoResDto consignmentSellerInfo;
    private PdtStaticDto.CtgL4Dto ctgL4;
    private Boolean boardLike;
    private List<PdtStaticDto.ProductImgResDto> thumbImgList;
    private List<PdtStaticDto.ProductImgResDto> detailImgList;
    private List<PdtStaticDto.MainProductResDto> mainProductList;
    private List<PdtStaticDto.ProductRequiredInfoResDto> productRequiredInfoList;

    public PdtBoardDetailResDto(ProductBoard productBoard) {
        this.boardId = productBoard.getId();
        this.title = productBoard.getTitle();
        this.brand = productBoard.getBrand();
        this.salesSite = productBoard.getSalesSite().getValue();
        this.isEachShippingFee = productBoard.getIsEachShippingFee();
        this.isPremium = productBoard.getIsPremium();
        this.isCrossBorderShipping = productBoard.getIsCrossBorderShipping();
        this.isOnlineOnly = productBoard.getIsOnlineOnly();
        this.shippingFee = productBoard.getShippingFee();
        this.shippingFreeOver = productBoard.getShippingFreeOver();
        this.availableDeliveryJeju = productBoard.getAvailableDeliveryJeju();
        this.availableDeliveryIsland = productBoard.getAvailableDeliveryIsland();
        this.shippingFeeJeju = productBoard.getShippingFeeJeju();
        this.shippingFeeIsland = productBoard.getShippingFeeIsland();
        this.courierCompany = productBoard.getCourierCompany();
        this.pdtName = productBoard.getPdtName();
        this.returnAddress = AddressConverter.convertToString(productBoard.getReturnAddress());
        this.exchangeShippingFee = productBoard.getExchangeShippingFee();
        this.returnShippingFee = productBoard.getReturnShippingFee();
        this.premiumExchangeShippingFee = productBoard.getPremiumExchangeShippingFee();
        this.premiumReturnShippingFee = productBoard.getPremiumReturnShippingFee();
        this.totalReviewQty = productBoard.getTotalReviewQty();
        this.totalScore = productBoard.getTotalScore();
        this.isSamePrice = productBoard.getIsSamePrice();
        this.minPrice = productBoard.getMinPrice();
        this.salesVol = productBoard.getSalesVol();
        this.deliveryDate = productBoard.getDeliveryDate();
        this.consignmentSellerInfo = new PdtStaticDto.ConsignmentSellerInfoResDto(
                productBoard.getConsignmentSellerInfo().getName(),
                AddressConverter.convertToString(productBoard.getConsignmentSellerInfo().getConsignmentSellerAddress()),
                productBoard.getConsignmentSellerInfo().getMailOrderNum());
        this.ctgL4 = new PdtStaticDto.CtgL4Dto(productBoard.getCategoryL4().getId(),
                productBoard.getCategoryL4().getName());
        this.thumbImgList = productBoard.getThumbImgList()
                .stream().map(img -> new PdtStaticDto.ProductImgResDto(img.getImgPath()))
                .collect(Collectors.toList());
        this.detailImgList = productBoard.getDetailImgList()
                .stream().map(img -> new PdtStaticDto.ProductImgResDto(img.getImgPath()))
                .collect(Collectors.toList());
        this.mainProductList = productBoard.getMainProductList()
                .stream().map(pdt -> new PdtStaticDto.MainProductResDto(
                        pdt.getId(),
                        pdt.getModelCode(),
                        pdt.getOptionName1(),
                        pdt.getOptionValue1(),
                        pdt.getOptionName2(),
                        pdt.getOptionValue2(),
                        pdt.getPrice(),
                        pdt.getStock()))
                .collect(Collectors.toList());
        this.productRequiredInfoList = productBoard.getProductRequiredInfoList()
                .stream().map(info -> new PdtStaticDto.ProductRequiredInfoResDto(info.getInfoTitle(), info.getInfoCnt()))
                .collect(Collectors.toList());
    }

    public PdtBoardDetailResDto boardLike(Boolean bool) {
        this.boardLike = bool;
        return this;
    }
}
