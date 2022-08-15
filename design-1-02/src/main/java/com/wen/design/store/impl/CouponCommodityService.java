package com.wen.design.store.impl;

import com.alibaba.fastjson.JSON;
import com.wen.design.coupon.CouponResult;
import com.wen.design.coupon.CouponService;
import com.wen.design.store.ICommodityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * <p>
 * 优惠券商品服务
 * </p>
 *
 * @author wenjun
 * @since 2022-08-15
 */
public class CouponCommodityService implements ICommodityService {

    private final Logger logger = LoggerFactory.getLogger(CouponCommodityService.class);

    /**
     * 优惠券服务
     */
    private final CouponService couponService = new CouponService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        CouponResult couponResult = couponService.sendCoupon(uId, commodityId, bizId);
        logger.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[优惠券]：{}", JSON.toJSON(couponResult));
        if (!"0000".equals(couponResult.getCode())) {
            throw new RuntimeException(couponResult.getInfo());
        }
    }
}