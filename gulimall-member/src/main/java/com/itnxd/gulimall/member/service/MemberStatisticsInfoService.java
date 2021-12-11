package com.itnxd.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itnxd.common.utils.PageUtils;
import com.itnxd.gulimall.member.entity.MemberStatisticsInfoEntity;

import java.util.Map;

/**
 * 
 *
 * @author ITNXD
 * @email niuxvdong@gmail.com
 * @date 2021-12-10 18:40:21
 */
public interface MemberStatisticsInfoService extends IService<MemberStatisticsInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

