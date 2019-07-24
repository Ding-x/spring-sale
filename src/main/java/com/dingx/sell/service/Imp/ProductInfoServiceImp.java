package com.dingx.sell.service.Imp;

import com.dingx.sell.dataobject.ProductInfo;
import com.dingx.sell.dto.CartDTO;
import com.dingx.sell.enums.ProductStatusEnum;
import com.dingx.sell.enums.ResultEnum;
import com.dingx.sell.exception.SellException;
import com.dingx.sell.repository.ProductInfoRepository;
import com.dingx.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductInfoServiceImp implements ProductInfoService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.getOne(productId);
    }

    @Override
    public List<ProductInfo> findAllUp() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO:cartDTOList){
            ProductInfo productInfo = repository.getOne(cartDTO.getProductId());
            if (productInfo==null)
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);

            Integer result = productInfo.getProductStock() + cartDTO.getQuantity();
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO:cartDTOList){
            ProductInfo productInfo = repository.getOne(cartDTO.getProductId());
            if (productInfo==null)
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);

            Integer result = productInfo.getProductStock() - cartDTO.getQuantity();
            if (result<0)
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }

    }
}
