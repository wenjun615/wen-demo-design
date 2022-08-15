package com.wen.design.store;

import java.util.Map;

/**
 * <p>
 * 商品服务接口
 * </p>
 *
 * @author wenjun
 * @since 2022-08-15
 */
public interface ICommodityService {

    /**
     * 发放商品
     *
     * @param uId         用户 id
     * @param commodityId 商品 id
     * @param bizId       业务 id
     * @param extMap      扩展信息
     * @throws Exception 异常
     */
    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;

}