package com.easymall.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author liweijun
 * @Date 2021/3/9
 * @description：购物车信息
 **/
@Data
public class MallCartPOJO implements Serializable {

    @ApiModelProperty("购物车ID")
    private String cartId;
    @ApiModelProperty("用户ID")
    private String userId;
    @ApiModelProperty("商品ID")
    private String goodsId;
    @ApiModelProperty("数量")
    private String quantity;
    @ApiModelProperty("是否选择,1=已勾选,0=未勾选")
    private String checked;
    @ApiModelProperty("创建时间")
    private String  createTime;
    @ApiModelProperty("最后修改时间")
    private String  updateTime;

}
