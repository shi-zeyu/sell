package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import com.imooc.repository.ProductCategoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Sheldon_Shi
 * @Date 2018/9/26 0026
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {
        ProductCategory productCategory = categoryService.findOne(1);
        Assert.assertEquals("热销榜",productCategory.getCategoryName());
    }

    @Test
    public void findAll() {
        List<ProductCategory> list = categoryService.findAll();
        Assert.assertNotEquals(new Integer(0),new Integer(list.size()));
    }

    @Test
    public void findByCategoryIn() {
        List<ProductCategory> list = categoryService.findByCategoryTypeIn(Arrays.asList(1));
        Assert.assertNotEquals(new Integer(0),new Integer(list.size()));
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("男生专享");
        productCategory.setCategoryType(3);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }
}