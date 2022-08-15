package com.wen.design;

import java.util.Map;

/**
 * <p>
 * 发奖请求
 * </p>
 *
 * @author wenjun
 * @since 2022-08-15
 */
public class AwardReq {

    /**
     * 用户 id
     */
    private String uId;

    /**
     * 奖品类型：1优惠券、2实物商品、3第三方兑换卡(爱奇艺)
     */
    private Integer awardType;

    /**
     * 奖品号码
     */
    private String awardNumber;

    /**
     * 业务 id，防重复
     */
    private String bizId;

    /**
     * 扩展信息
     */
    private Map<String, String> extMap;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Integer getAwardType() {
        return awardType;
    }

    public void setAwardType(Integer awardType) {
        this.awardType = awardType;
    }

    public String getAwardNumber() {
        return awardNumber;
    }

    public void setAwardNumber(String awardNumber) {
        this.awardNumber = awardNumber;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Map<String, String> getExtMap() {
        return extMap;
    }

    public void setExtMap(Map<String, String> extMap) {
        this.extMap = extMap;
    }
}