package test;

import com.wen.design.StoreFactory;
import com.wen.design.store.ICommodityService;
import org.junit.Test;

import java.util.HashMap;

/**
 * <p>
 * 测试
 * </p>
 *
 * @author wenjun
 * @since 2022-08-15
 */
public class ApiTest {

    @Test
    public void test_commodity() throws Exception {
        StoreFactory storeFactory = new StoreFactory();
        // 1. 优惠券
        ICommodityService couponCommodityService = storeFactory.getCommodityService(1);
        couponCommodityService.sendCommodity("10001", "EGM1023938910232121323432", "791098764902132", null);
        // 2. 实物商品
        ICommodityService goodsCommodityService = storeFactory.getCommodityService(2);
        goodsCommodityService.sendCommodity("10001", "9820198721311", "1023000020112221113",
                new HashMap<>() {{
                    put("consigneeUserName", "谢飞机");
                    put("consigneeUserPhone", "15200292123");
                    put("consigneeUserAddress", "吉林省.长春市.双阳区.XX街道.檀溪苑小区.#18-2109");
                }});
        // 3. 第三方兑换卡(爱奇艺)
        ICommodityService cardCommodityService = storeFactory.getCommodityService(3);
        cardCommodityService.sendCommodity("10001", "AQY1xjkUodl8LO975GdfrYUio", null, null);
    }

}
