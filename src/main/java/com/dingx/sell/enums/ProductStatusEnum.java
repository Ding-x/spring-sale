package com.dingx.sell.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum {

    UP(0,"Sale"),DOWN(1,"Out of Sale");

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
