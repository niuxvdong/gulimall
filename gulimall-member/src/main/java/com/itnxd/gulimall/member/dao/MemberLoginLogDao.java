package com.itnxd.gulimall.member.dao;

import com.itnxd.gulimall.member.entity.MemberLoginLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员登录记录
 * 
 * @author ITNXD
 * @email niuxvdong@gmail.com
 * @date 2021-12-10 18:40:20
 */
@Mapper
public interface MemberLoginLogDao extends BaseMapper<MemberLoginLogEntity> {
	
}
