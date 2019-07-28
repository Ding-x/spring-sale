package com.dingx.sell.service;

import com.dingx.sell.dto.OrderDTO;

public interface BuyerService {

    OrderDTO findOrderOne(String openid, String orderId);

    OrderDTO cancelOrder(String openid, String orderId);
}
