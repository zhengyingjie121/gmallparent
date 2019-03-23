package com.atguigu.gmall.pms.service.impl;

import com.atguigu.gmall.pms.entity.ProductCategory;
import com.atguigu.gmall.pms.mapper.ProductCategoryMapper;
import com.atguigu.gmall.pms.service.ProductCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 产品分类 服务实现类
 * </p>
 *
 * @author Lfy
 * @since 2019-03-19
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {
//分页查询商品分类
    @Override
    public Map<String, Object> PageproductCategory(Integer pageNum, Integer pageSize) {
        ProductCategoryMapper baseMapper = getBaseMapper();

        return null;
    }
}
