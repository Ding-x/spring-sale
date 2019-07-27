package com.dingx.sell.enums;


import lombok.Getter;


@Getter
public enum ResultEnum {

    SUCCESS(0, "Success"),

    PARAM_ERROR(1, "Parameter invalid"),

    PRODUCT_NOT_EXIST(10, "product not existed"),

    PRODUCT_STOCK_ERROR(11, "product stock invalid"),

    ORDER_NOT_EXIST(12, "order not existed"),

    ORDERDETAIL_NOT_EXIST(13, "order detail not existed"),

    ORDER_STATUS_ERROR(14, "order status wrong"),

    ORDER_UPDATE_FAIL(15, "order update failed"),

    ORDER_DETAIL_EMPTY(16, "order detail is empty"),

    ORDER_PAY_STATUS_ERROR(17, "pay status invalid"),

    CART_EMPTY(18, "shopping cart empty"),

    ORDER_OWNER_ERROR(19, "order does not belong to current user"),

    WECHAT_MP_ERROR(20, "wechat openid wrong"),

    WXPAY_NOTIFY_MONEY_VERIFY_ERROR(21, "wechat pay failed"),

    ORDER_CANCEL_SUCCESS(22, "order cancel success"),

    ORDER_FINISH_SUCCESS(23, "order completed success"),

    PRODUCT_STATUS_ERROR(24, "product status wrong"),

    LOGIN_FAIL(25, "login failed, info wrong"),

    LOGOUT_SUCCESS(26, "logout success"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
