package com.dingx.sell.enums;

import lombok.Getter;


@Getter
public enum OrderStatusEnum  {
    NEW(0, "New"),
    FINISHED(1, "Completed"),
    CANCEL(2, "Canceled"),
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
