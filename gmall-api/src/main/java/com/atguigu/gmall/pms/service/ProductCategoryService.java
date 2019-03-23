package com.atguigu.gmall.pms.service;

import com.atguigu.gmall.pms.entity.ProductCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 产品分类 服务类
 * </p>
 *
 * @author Lfy
 * @since 2019-03-19
 */
public interface ProductCategoryService extends IService<ProductCategory> {
    //分页查询商品分类
    Map<String,Object> PageproductCategory(Integer pageNum, Integer pageSize);
}
