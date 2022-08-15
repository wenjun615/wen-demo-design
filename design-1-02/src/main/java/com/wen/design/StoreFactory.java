package com.wen.design;

import com.wen.design.store.ICommodityService;
import com.wen.design.store.impl.CardCommodityService;
import com.wen.design.store.impl.CouponCommodityService;
import com.wen.design.store.impl.GoodsCommodityService;

/**
 * <p>
 * 商店工厂
 * </p>
 *
 * @author wenjun
 * @since 2022-08-15
 */
public class StoreFactory {

    /**
     * 获取商品服务
     *
     * @param commodityType 商品类型
     * @return 商品服务
     */
    public ICommodityService getCommodityService(int commodityType) {
        if (commodityType == 1) {
            return new CouponCommodityService();
        }
        if (commodityType == 2) {
            return new GoodsCommodityService();
        }
        if (commodityType == 3) {
            return new CardCommodityService();
        }
        throw new RuntimeException("不存在的商品服务类型");
    }

}