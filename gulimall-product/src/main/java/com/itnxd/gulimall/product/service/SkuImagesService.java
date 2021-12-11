package com.itnxd.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itnxd.common.utils.PageUtils;
import com.itnxd.gulimall.product.entity.SkuImagesEntity;

import java.util.Map;

/**
 * sku图片
 *
 * @author ITNXD
 * @email niuxvdong@gmail.com
 * @date 2021-12-10 17:38:29
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

