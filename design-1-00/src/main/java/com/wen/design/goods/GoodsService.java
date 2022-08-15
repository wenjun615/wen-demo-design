package com.wen.design.goods;

import com.alibaba.fastjson.JSON;

/**
 * <p>
 * 实物商品服务
 * </p>
 *
 * @author wenjun
 * @since 2022-08-15
 */
public class GoodsService {

    /**
     * 运送商品
     *
     * @param req 运送请求
     * @return 是否成功
     */
    public boolean deliverGoods(DeliverReq req) {
        System.out.println("发货商品：" + JSON.toJSONString(req));
        return true;
    }

}