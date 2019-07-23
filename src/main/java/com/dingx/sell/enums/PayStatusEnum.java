package com.dingx.sell.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum  {

    WAIT(0, "Waiting"),
    SUCCESS(1, "Success"),
    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}