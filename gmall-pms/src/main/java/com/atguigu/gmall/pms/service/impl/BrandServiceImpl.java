package com.atguigu.gmall.pms.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.atguigu.gmall.pms.entity.Brand;
import com.atguigu.gmall.pms.mapper.BrandMapper;
import com.atguigu.gmall.pms.service.BrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author Lfy
 * @since 2019-03-19
 */
@EnableDubbo
@Component
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {



    @Override
    public Map<String, Object> pageBrand(String keyword, Integer pageNum, Integer pageSize) {
        BrandMapper brandMapper = getBaseMapper();
        QueryWrapper<Brand> eq = null;
        if (!StringUtils.isEmpty(keyword)){
           eq = new QueryWrapper<Brand>().like("name",keyword)
                    .eq("first_letter",keyword);
        }
     //到数据库中查询
       IPage<Brand> selectPage = brandMapper.selectPage(new Page<>(pageNum,pageSize),eq);
        //封装数据返回给前台
        //封装数据，给前台返回
        Map<String, Object> map = new HashMap<>();
        map.put("pageSize",pageSize);
        map.put("totalPage",selectPage.getPages());
        map.put("total",selectPage.getTotal());
        map.put("pageNum",selectPage.getCurrent());
        map.put("list",selectPage.getRecords());
        return map;
    }
}
