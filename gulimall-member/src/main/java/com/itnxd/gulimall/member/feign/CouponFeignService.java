package com.itnxd.gulimall.member.feign;

import com.itnxd.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ITNXD
 * @create 2021-12-11 10:10
 */
@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/member/list")
    public R couponMember();
}
