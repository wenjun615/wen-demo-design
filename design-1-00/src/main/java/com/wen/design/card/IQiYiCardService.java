package com.wen.design.card;

/**
 * <p>
 * 爱奇艺会员卡服务
 * </p>
 *
 * @author wenjun
 * @since 2022-08-15
 */
public class IQiYiCardService {

    /**
     * 发放会员卡
     *
     * @param bindMobileNumber 绑定手机号码
     * @param cardId           会员卡主键 id
     */
    public void grantToken(String bindMobileNumber, String cardId) {
        System.out.println("发放会员卡：" + bindMobileNumber + "，" + cardId);
    }

}