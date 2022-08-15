package com.wen.design;

/**
 * <p>
 * 发奖结果
 * </p>
 *
 * @author wenjun
 * @since 2022-08-15
 */
public class AwardRes {

    /**
     * 编码
     */
    private String code;

    /**
     * 描述
     */
    private String info;

    public AwardRes(String code, String info) {
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