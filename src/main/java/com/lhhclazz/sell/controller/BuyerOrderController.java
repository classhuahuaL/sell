package com.lhhclazz.sell.controller;

import com.lhhclazz.sell.VO.ResultVO;
import com.lhhclazz.sell.converter.OrderForm2OrderDTOConverter;
import com.lhhclazz.sell.dataobject.OrderDetail;
import com.lhhclazz.sell.dataobject.OrderMaster;
import com.lhhclazz.sell.dto.OrderDTO;
import com.lhhclazz.sell.enums.ResultEnum;
import com.lhhclazz.sell.exception.SellException;
import com.lhhclazz.sell.form.OrderForm;
import com.lhhclazz.sell.service.OrderService;
import com.lhhclazz.sell.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单提交处理的controller
 */
@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     * @param orderForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if(orderDTO.getOrderDetailList() == null && orderDTO.getOrderDetailList().size() < 0 ){
            throw  new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO dto = orderService.create(orderDTO);
        Map<String,String> map = new HashMap<>();
        map.put("orderId",dto.getOrderId());

        return ResultVOUtil.success(map);

    }

    /**
     * 查询数据并且分页
     * @param openid
     * @param page
     * @param size
     * @return
     */
    @GetMapping("list")
    public ResultVO<List<OrderDTO>> list(@RequestParam(value = "openid") String openid,@RequestParam(value = "page",defaultValue = "0") Integer page,@RequestParam(value = "size",defaultValue = "10") Integer size){
        PageRequest pageRequest = new PageRequest(page,size);
        if(StringUtils.isEmpty(openid)){
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        Page<OrderDTO> orderDTOS = orderService.findList(openid, pageRequest);
        return ResultVOUtil.success(orderDTOS.getContent());
    }

    /**
     * 查询订单详细
     * @param openid
     * @param orderId
     * @return
     */
    @GetMapping("detail")
    public ResultVO<OrderDetail> findOne(@RequestParam(value = "openid") String openid,@RequestParam(value = "orderId") String orderId){
        if(StringUtils.isEmpty(orderId)){
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        if(StringUtils.isEmpty(openid)){
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        OrderDTO dto = orderService.findOne(orderId);
        return ResultVOUtil.success(dto);
    }
    public ResultVO<OrderDTO> cancel(@RequestParam("openid") String openid,@RequestParam("orderId") String orderId){
        if(StringUtils.isEmpty(openid)){
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        OrderDTO orderDTO = orderService.findOne(orderId);
        OrderDTO cancel = orderService.cancel(orderDTO);
        return ResultVOUtil.success(cancel);
    }


}
