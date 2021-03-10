package com.easymall.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author liweijun
 * @Date 2021/3/9
 * @description：订单信息
 **/
@Data
public class MallOrderPOJO implements Serializable {

    @ApiModelProperty("订单ID")
    private String orderId;
    @ApiModelProperty("用户ID")
    private String userId;
    @ApiModelProperty("商品ID")
    private String goodsId;
    @ApiModelProperty("实际付款金额,单位是元,保留两位小数")
    private String payment;
    @ApiModelProperty("支付类型,1-在线支付")
    private String paymentType;
    @ApiModelProperty("运费,单位是元")
    private String postage;
    @ApiModelProperty("订单状态:0-已取消，10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭")
    private String status;
    @ApiModelProperty("支付时间")
    private String paymentTime;
    @ApiModelProperty("发货时间")
    private String sendTime;
    @ApiModelProperty("交易完成时间")
    private String endTime;
    @ApiModelProperty("交易关闭时间")
    private String closeTime;
    @ApiModelProperty("创建时间")
    private String createTime;
    @ApiModelProperty("最后修改时间")
    private String updateTime;
}
