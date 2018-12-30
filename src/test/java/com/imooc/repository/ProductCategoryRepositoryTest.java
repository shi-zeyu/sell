package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * @author Sheldon_Shi
 * @Date 2018/9/26 0026
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findAllTest() {
        List<ProductCategory> list = repository.findAll();
        Assert.assertEquals(new Integer(1),new Integer(list.size()));
    }

    @Test
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("热销榜");
        productCategory.setCategoryType(2);
        repository.save(productCategory);
    }

    @Test
    public void findOneTest() {
        Optional<ProductCategory> optional = repository.findById(1);
        Assert.assertEquals("热销榜",optional.get().getCategoryName());
    }

    @Test
    public void updateTest() {
        Optional<ProductCategory> optional = repository.findById(1);
        optional.get().setCategoryName("最低销量榜");
        repository.save(optional.get());
        Assert.assertEquals("热销榜",optional.get().getCategoryName());
    }
}