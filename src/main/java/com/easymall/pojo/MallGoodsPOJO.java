package com.easymall.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author liweijun
 * @Date 2021/3/8
 * @description：商品信息
 **/
@Data
public class MallGoodsPOJO implements Serializable {

    @ApiModelProperty("商品ID")
    private String  goodsId;
    @ApiModelProperty("商品名称")
    private String  goodsName;
    @ApiModelProperty("品牌")
    private String  brand;
    @ApiModelProperty("分类")
    private String  cate;
    @ApiModelProperty("商品价格")
    private Double  price;
    @ApiModelProperty("商品原价")
    private Double  original;
    @ApiModelProperty("商品标签")
    private String  tags;
    @ApiModelProperty("商品内容")
    private String  content;
    @ApiModelProperty("商品描述")
    private String  summary;
    @ApiModelProperty("商品状态(-1删除,10未审核,11已审核,20上架中,21已下架,22已出售)")
    private String  status;
    @ApiModelProperty("商品主图")
    private String  goodsMainImage;
    @ApiModelProperty("商品子图")
    private String  goodsSubImages;
    @ApiModelProperty("商品所属用户ID")
    private String  userId;
    @ApiModelProperty("创建时间")
    private String  createTime;
    @ApiModelProperty("最后修改时间")
    private String  updateTime;

}
