package com.dingx.sell.exception;

import com.dingx.sell.enums.ResultEnum;

public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }

    public SellException(ResultEnum resultEnum, String message){
        super(message);
        this.code=resultEnum.getCode();
    }

}
