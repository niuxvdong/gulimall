package com.itnxd.gulimall.order.dao;

import com.itnxd.gulimall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author ITNXD
 * @email niuxvdong@gmail.com
 * @date 2021-12-10 21:14:11
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
