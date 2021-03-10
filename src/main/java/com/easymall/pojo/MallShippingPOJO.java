package com.easymall.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author liweijun
 * @Date 2021/3/9
 * @description：收货地址信息
 **/
@Data
public class MallShippingPOJO implements Serializable {

    @ApiModelProperty("收货地址ID")
    private String shipId;
    @ApiModelProperty("用户ID")
    private String userId;
    @ApiModelProperty("收货姓名")
    private String  receiverName;
    @ApiModelProperty("收货电话")
    private String receiverPhone;
    @ApiModelProperty("省份")
    private String receiverProvince;
    @ApiModelProperty("城市")
    private String receiverCity;
    @ApiModelProperty("区/县")
    private String receiverDistrict;
    @ApiModelProperty("详细地址")
    private String receiverAddress;
    @ApiModelProperty("邮编")
    private String receiverZip;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("最后更新时间")
    private Date updateTime;
}
