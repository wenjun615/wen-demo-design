package com.wen.design.store.impl;

import com.alibaba.fastjson.JSON;
import com.wen.design.card.IQiYiCardService;
import com.wen.design.store.ICommodityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * <p>
 * 会员卡商品服务
 * </p>
 *
 * @author wenjun
 * @since 2022-08-15
 */
public class CardCommodityService implements ICommodityService {

    private final Logger logger = LoggerFactory.getLogger(CardCommodityService.class);

    /**
     * 爱奇艺会员卡服务
     */
    private final IQiYiCardService iQiYiCardService = new IQiYiCardService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        String mobile = queryUserMobile(uId);
        iQiYiCardService.grantToken(mobile, bizId);
        logger.info("请求参数[爱奇艺兑换卡] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[爱奇艺兑换卡]：success");
    }

    /**
     * 查询用户手机
     *
     * @param uId 用户 id
     * @return 用户手机
     */
    private String queryUserMobile(String uId) {
        return "15200101232";
    }

}