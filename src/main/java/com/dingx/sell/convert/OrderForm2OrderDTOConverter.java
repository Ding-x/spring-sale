package com.dingx.sell.convert;

import com.dingx.sell.dataobject.OrderDetail;
import com.dingx.sell.dto.OrderDTO;
import com.dingx.sell.enums.ResultEnum;
import com.dingx.sell.exception.SellException;
import com.dingx.sell.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
