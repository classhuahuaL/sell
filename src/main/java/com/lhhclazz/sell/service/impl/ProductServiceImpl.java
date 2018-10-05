package com.lhhclazz.sell.service.impl;

import com.lhhclazz.sell.dataobject.ProductInfo;
import com.lhhclazz.sell.dto.CartDTO;
import com.lhhclazz.sell.enums.ProductStatusEnum;
import com.lhhclazz.sell.enums.ResultEnum;
import com.lhhclazz.sell.exception.SellException;
import com.lhhclazz.sell.repository.ProductInfoRepository;
import com.lhhclazz.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findByProductId(productId);
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public void save(ProductInfo productInfo) {
        repository.save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO : cartDTOList){
            ProductInfo productId = repository.findByProductId(cartDTO.getProductId());
            if(productId == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer productStock = productId.getProductStock() - cartDTO.getProductStock();
            if(productStock < 0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productId.setProductStock(productStock);
            repository.save(productId);
        }
    }

    @Override
    public ProductInfo onSale(String productId) {
        return null;
    }

    @Override
    public ProductInfo offSale(String productId) {
        return null;
    }
}
