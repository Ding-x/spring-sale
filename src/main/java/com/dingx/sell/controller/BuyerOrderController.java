package com.dingx.sell.controller;

import com.dingx.sell.VO.ResultVO;
import com.dingx.sell.convert.OrderForm2OrderDTOConverter;
import com.dingx.sell.dto.OrderDTO;
import com.dingx.sell.enums.ResultEnum;
import com.dingx.sell.exception.SellException;
import com.dingx.sell.form.OrderForm;
import com.dingx.sell.service.OrderService;
import com.dingx.sell.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    public ResultVO<Map<String,String>> create (@Valid OrderForm orderForm, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            throw new SellException(ResultEnum.PARAM_ERROR,bindingResult.getFieldError().getDefaultMessage());

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO createResult = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());

        return ResultVOUtil.success(map);


    }
}
