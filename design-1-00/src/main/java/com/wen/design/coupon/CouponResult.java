package com.wen.design.coupon;

/**
 * <p>
 * 优惠券结果
 * </p>
 *
 * @author wenjun
 * @since 2022-08-15
 */
public class CouponResult {

    /**
     * 编码
     */
    private String code;

    /**
     * 描述
     */
    private String info;

    public CouponResult(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}