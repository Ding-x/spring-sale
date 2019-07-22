package com.dingx.sell.service.Imp;

import com.dingx.sell.dataobject.ProductInfo;
import com.dingx.sell.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImpTest {
    @Autowired
    private ProductInfoServiceImp productInfoService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productInfoService.findOne("123");
        Assert.assertEquals("123",productInfo.getProductId());
    }

    @Test
    public void findAllSale() {
        List<ProductInfo> result = productInfoService.findAllUp();
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void findAll() {
        PageRequest request = PageRequest.of(0,2);
        Page<ProductInfo> productInfoPage = productInfoService.findAll(request);
        System.out.println(productInfoPage.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("111");
        productInfo.setProductName("summer roll");
        productInfo.setProductPrice(new BigDecimal(5.2));
        productInfo.setProductStock(100);
        productInfo.setProductIcon("xxx,jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);

        ProductInfo result = productInfoService.save(productInfo);

        Assert.assertNotNull(result);
    }
}