package com.gmhu.mycoupon.service;

import com.gmhu.mycoupon.common.dto.Coupon;

/**
 * @Description:
 * @Author: huguangmiao
 * @Date: 2020/12/18
 */
public interface IndexService {

    /**
     * @Description: 查询优惠券
     * @Author: gmhu
     * @Date: 2020/12/21 17:20
     */
    Coupon getCoupon(String cateId);
}
