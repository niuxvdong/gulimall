package com.itnxd.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itnxd.common.utils.PageUtils;
import com.itnxd.gulimall.product.entity.CategoryEntity;

import java.util.Map;

/**
 * 商品三级分类
 *
 * @author ITNXD
 * @email niuxvdong@gmail.com
 * @date 2021-12-10 17:38:31
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

