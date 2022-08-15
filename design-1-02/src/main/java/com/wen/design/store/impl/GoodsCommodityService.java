package com.wen.design.store.impl;

import com.alibaba.fastjson.JSON;
import com.wen.design.goods.DeliverReq;
import com.wen.design.goods.GoodsService;
import com.wen.design.store.ICommodityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * <p>
 * 实物商品服务
 * </p>
 *
 * @author wenjun
 * @since 2022-08-15
 */
public class GoodsCommodityService implements ICommodityService {

    private final Logger logger = LoggerFactory.getLogger(GoodsCommodityService.class);

    /**
     * 实物商品服务
     */
    private final GoodsService goodsService = new GoodsService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        DeliverReq deliverReq = new DeliverReq();
        deliverReq.setUserName(queryUserName(uId));
        deliverReq.setUserPhone(queryUserPhoneNumber(uId));
        deliverReq.setSku(commodityId);
        deliverReq.setOrderId(bizId);
        deliverReq.setConsigneeUserName(extMap.get("consigneeUserName"));
        deliverReq.setConsigneeUserPhone(extMap.get("consigneeUserPhone"));
        deliverReq.setConsigneeUserAddress(extMap.get("consigneeUserAddress"));
        boolean isSuccess = goodsService.deliverGoods(deliverReq);
        logger.info("请求参数[实物商品] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[实物商品]：{}", isSuccess);
        if (!isSuccess) {
            throw new RuntimeException("实物商品发放失败");
        }
    }

    /**
     * 查询用户姓名
     *
     * @param uId 用户 id
     * @return 用户姓名
     */
    private String queryUserName(String uId) {
        return "花花";
    }

    /**
     * 查询用户电话号码
     *
     * @param uId 用户 id
     * @return 用户电话号码
     */
    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }

}
