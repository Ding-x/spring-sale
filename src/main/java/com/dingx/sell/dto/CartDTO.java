package com.dingx.sell.dto;

import lombok.Data;

@Data
public class CartDTO {

    private String productId;
    private Integer quantity;

    public CartDTO(String productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
