package com.easymall.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author liweijun
 * @Date 2021/3/30
 * @description：
 **/
@Data
public class LoginVO implements Serializable {

    private String loginName;
    private String password;
    private String userType;

}
