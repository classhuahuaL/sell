package com.lhhclazz.sell.service.impl;

import com.lhhclazz.sell.dataobject.OrderDetail;
import com.lhhclazz.sell.dataobject.OrderMaster;
import com.lhhclazz.sell.dataobject.ProductInfo;
import com.lhhclazz.sell.dto.CartDTO;
import com.lhhclazz.sell.dto.OrderDTO;
import com.lhhclazz.sell.enums.OrderStatusEnum;
import com.lhhclazz.sell.enums.PayStatusEnum;
import com.lhhclazz.sell.enums.ResultEnum;
import com.lhhclazz.sell.exception.SellException;
import com.lhhclazz.sell.repository.OrderDetailRepository;
import com.lhhclazz.sell.repository.OrderMasterRepository;
import com.lhhclazz.sell.repository.ProductInfoRepository;
import com.lhhclazz.sell.service.OrderService;
import com.lhhclazz.sell.service.ProductService;
import com.lhhclazz.sell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {

        BigDecimal bigDecimal = new BigDecimal(0);

        String orderId = KeyUtil.genUniqueKey();

        for(OrderDetail orderDetail :orderDTO.getOrderDetailList()){
            ProductInfo productId = productService.findOne(orderDetail.getProductId());
            if(productId == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            bigDecimal = productId.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(bigDecimal);
            BeanUtils.copyProperties(productId,orderDetail);
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            orderDetailRepository.save(orderDetail);
        }

        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(bigDecimal);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);

        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e -> new CartDTO(e.getProductQuantity(),e.getProductId())).collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);

        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {

        OrderMaster orderId1 = orderMasterRepository.findByOrderId(orderId);
        if(orderId1 == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderId1,orderDTO);
        List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId(orderId1.getOrderId());
        if(orderDetails == null && orderDetails.size() < 0){
            throw new SellException(ResultEnum.ORDERDETAIL_NOT_EXIST);
        }
        orderDTO.setOrderDetailList(orderDetails);

        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        Page<OrderMaster> orderMasters = orderMasterRepository.findByBuyerOpenid(buyerOpenid, pageable);

        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(Pageable pageable) {
        return null;
    }
}
