package com.itnxd.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itnxd.common.utils.PageUtils;
import com.itnxd.gulimall.coupon.entity.HomeSubjectSpuEntity;

import java.util.Map;

/**
 * δΈι’εε
 *
 * @author ITNXD
 * @email niuxvdong@gmail.com
 * @date 2021-12-10 18:28:52
 */
public interface HomeSubjectSpuService extends IService<HomeSubjectSpuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

