package com.wen.design;

import com.alibaba.fastjson.JSON;
import com.wen.design.card.IQiYiCardService;
import com.wen.design.coupon.CouponResult;
import com.wen.design.coupon.CouponService;
import com.wen.design.goods.DeliverReq;
import com.wen.design.goods.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 发奖服务
 * </p>
 *
 * @author wenjun
 * @since 2022-08-15
 */
public class PrizeController {

    private final Logger logger = LoggerFactory.getLogger(PrizeController.class);

    /**
     * 发奖
     *
     * @param req 发奖请求
     * @return 发奖结果
     */
    public AwardRes awardToUser(AwardReq req) {
        String reqJson = JSON.toJSONString(req);
        AwardRes awardRes = null;
        try {
            logger.info("奖品发放开始{}。req:{}", req.getuId(), reqJson);
            // 根据不同类型发放奖品：1优惠券、2实物商品、3第三方兑换卡(爱奇艺)
            if (req.getAwardType() == 1) {
                CouponService couponService = new CouponService();
                CouponResult couponResult = couponService.sendCoupon(req.getuId(), req.getAwardNumber(), req.getBizId());
                if ("0000".equals(couponResult.getCode())) {
                    awardRes = new AwardRes("0000", "发放成功");
                } else {
                    awardRes = new AwardRes("0001", couponResult.getInfo());
                }
            } else if (req.getAwardType() == 2) {
                GoodsService goodsService = new GoodsService();
                DeliverReq deliverReq = new DeliverReq();
                deliverReq.setUserName(queryUserName(req.getuId()));
                deliverReq.setUserPhone(queryUserPhoneNumber(req.getuId()));
                deliverReq.setSku(req.getAwardNumber());
                deliverReq.setOrderId(req.getBizId());
                deliverReq.setConsigneeUserName(req.getExtMap().get("consigneeUserName"));
                deliverReq.setConsigneeUserPhone(req.getExtMap().get("consigneeUserPhone"));
                deliverReq.setConsigneeUserAddress(req.getExtMap().get("consigneeUserAddress"));
                boolean isSuccess = goodsService.deliverGoods(deliverReq);
                if (isSuccess) {
                    awardRes = new AwardRes("0000", "发放成功");
                } else {
                    awardRes = new AwardRes("0001", "发放失败");
                }
            } else if (req.getAwardType() == 3) {
                IQiYiCardService iQiYiCardService = new IQiYiCardService();
                iQiYiCardService.grantToken(queryUserPhoneNumber(req.getuId()), req.getAwardNumber());
                awardRes = new AwardRes("0000", "发放成功");
            }
            logger.info("奖品发放完成{}。", req.getuId());
        } catch (Exception e) {
            logger.error("奖品发放失败{}。req:{}", req.getuId(), reqJson, e);
            awardRes = new AwardRes("0001", e.getMessage());
        }
        return awardRes;
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