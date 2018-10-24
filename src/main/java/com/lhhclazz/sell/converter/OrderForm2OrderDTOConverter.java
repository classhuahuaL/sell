package com.lhhclazz.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lhhclazz.sell.dataobject.OrderDetail;
import com.lhhclazz.sell.dto.OrderDTO;
import com.lhhclazz.sell.enums.OrderStatusEnum;
import com.lhhclazz.sell.enums.ResultEnum;
import com.lhhclazz.sell.exception.SellException;
import com.lhhclazz.sell.form.OrderForm;

import java.util.ArrayList;
import java.util.List;

/**
 * 类转换
 */
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
