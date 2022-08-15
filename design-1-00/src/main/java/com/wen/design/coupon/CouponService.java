package com.wen.design.coupon;

/**
 * <p>
 * 优惠券服务
 * </p>
 *
 * @author wenjun
 * @since 2022-08-15
 */
public class CouponService {

    /**
     * 发放优惠券
     *
     * @param uId          用户 id
     * @param couponNumber 优惠券号码
     * @param uuid         随机 id
     * @return 优惠券结果
     */
    public CouponResult sendCoupon(String uId, String couponNumber, String uuid) {
        System.out.println("发放优惠券：" + uId + "," + couponNumber + "," + uuid);
        return new CouponResult("0000", "发放成功");
    }

}