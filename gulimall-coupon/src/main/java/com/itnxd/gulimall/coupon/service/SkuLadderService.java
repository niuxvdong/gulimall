package com.itnxd.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itnxd.common.utils.PageUtils;
import com.itnxd.gulimall.coupon.entity.SkuLadderEntity;

import java.util.Map;

/**
 * 商品阶梯价格
 *
 * @author ITNXD
 * @email niuxvdong@gmail.com
 * @date 2021-12-10 18:28:50
 */
public interface SkuLadderService extends IService<SkuLadderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

