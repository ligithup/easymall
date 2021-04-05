package com.easymall.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author liweijun
 * @Date 2021/4/5
 * @description：
 **/
@Data
public class UserIdStatus implements Serializable {

    private  String  userId;
    private  String  status;

}
