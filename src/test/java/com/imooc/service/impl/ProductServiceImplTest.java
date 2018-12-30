package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
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

import static org.junit.Assert.*;

/**
 * @author Sheldon_Shi
 * @Date 2018/9/27 0027
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productService.findOne("123456");
        Assert.assertNotNull(productInfo);
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertEquals(new Integer(1),new Integer(list.size()));
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(1,1);
        Page<ProductInfo> page = productService.findAll(request);
        Assert.assertEquals(new Integer(1),new Integer(page.getSize()));
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("皮皮虾");
        productInfo.setCategoryType(1);
        productInfo.setProductDescription("很好吃的虾");
        productInfo.setProductPrice(new BigDecimal(9.8));
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setProductStock(10);
        productInfo.setProductIcon("http://xxx.jpg");

        productService.save(productInfo);
        Assert.assertNotNull(productInfo);
    }
}