package com.easymall.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author liweijun
 * @Date 2021/3/6
 * @description：用户信息
 **/
@Data
public class SysUserPOJO implements Serializable {

    @ApiModelProperty("用户ID")
    private  String  userId;
    @ApiModelProperty("登录名")
    private  String  loginName;
    @ApiModelProperty("登录密码")
    private  String  password;
    @ApiModelProperty("用户名称")
    private  String  userName;
    @ApiModelProperty("性别")
    private  String  sex;
    @ApiModelProperty("用户类型(0管理用户,1普通用户)")
    private  String  userType;
    @ApiModelProperty("用户邮箱")
    private  String  email;
    @ApiModelProperty("用户联系方式")
    private  String  phone;
    @ApiModelProperty("帐号状态（0正常 1停用）")
    private  String  status;
    @ApiModelProperty("用户创建时间")
    private  Date    createTime;
    @ApiModelProperty("备注")
    private  String  remark;


}
