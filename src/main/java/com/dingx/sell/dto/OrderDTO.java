package com.dingx.sell.dto;

import com.dingx.sell.dataobject.OrderDetail;
import com.dingx.sell.enums.OrderStatusEnum;
import com.dingx.sell.utils.serializer.Date2LongSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus;

    private Integer payStatus;

    @JsonSerialize(using= Date2LongSerializer.class)
    private Date createTime;
    @JsonSerialize(using= Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;
}
