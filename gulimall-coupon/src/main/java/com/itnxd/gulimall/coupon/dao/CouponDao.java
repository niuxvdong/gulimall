package com.itnxd.gulimall.coupon.dao;

import com.itnxd.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author ITNXD
 * @email niuxvdong@gmail.com
 * @date 2021-12-10 18:28:53
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
