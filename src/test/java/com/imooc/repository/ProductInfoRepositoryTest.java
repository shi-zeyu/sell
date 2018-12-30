package com.imooc.repository;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.imooc.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Sheldon_Shi
 * @Date 2018/9/26 0026
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("皮蛋粥");
        productInfo.setCategoryType(1);
        productInfo.setProductDescription("很好喝的早餐");
        productInfo.setProductPrice(new BigDecimal(8.8));
        productInfo.setProductStatus(0);
        productInfo.setProductStock(10);
        productInfo.setProductIcon("http://xxx.jpg");
        repository.save(productInfo);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> list = repository.findByProductStatus(0);
        Assert.assertEquals("皮蛋粥",list.get(0).getProductName());
    }

    @Test
    public void text() {
        Integer a = 1;
        Integer b = 2;
        System.out.println(a==b);
    }
}