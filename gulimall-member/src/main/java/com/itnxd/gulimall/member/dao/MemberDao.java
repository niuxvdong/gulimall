package com.itnxd.gulimall.member.dao;

import com.itnxd.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author ITNXD
 * @email niuxvdong@gmail.com
 * @date 2021-12-10 18:40:21
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
