package com.easymall.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author liweijun
 * @Date 2021/3/9
 * @description：订单明细信息
 **/
@Data
public class MallOrderItemPOJO implements Serializable {

    @ApiModelProperty("订单明细ID")
    private String orderItemId;
    @ApiModelProperty("用户ID")
    private String userId;
    @ApiModelProperty("订单ID")
    private String orderId;
    @ApiModelProperty("商品ID")
    private String goodsId;
    @ApiModelProperty("生成订单时的商品单价，单位是元,保留两位小数")
    private String currentUnitPrice;
    @ApiModelProperty("商品数量")
    private String quantity;
    @ApiModelProperty("商品总价,单位是元,保留两位小数")
    private String totalPrice;
    @ApiModelProperty("创建时间")
    private String createTime;
    @ApiModelProperty("最后修改时间")
    private String updateTime;


}
