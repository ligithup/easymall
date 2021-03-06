package com.easymall.mapper;

import com.easymall.pojo.SysUserPOJO;
import com.easymall.pojo.UserIdStatus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author liweijun
 * @Date 2020/1/15
 * @description：
 **/
public interface SysUserMapper {

     void addUser(SysUserPOJO sysUserPOJO);

     SysUserPOJO login(@Param("loginName") String loginName,@Param("password") String password,@Param("userType") String userType);

     List<SysUserPOJO> selectUser();

     SysUserPOJO selectUserByLoginName(@Param("loginName") String loginName);

     List<SysUserPOJO> selectUserByUserName(@Param("userName") String userName);

     int deleteUserByUserId(String[] userIds);

    int updateUserByUserId(SysUserPOJO sysUserPOJO);

    int updateUserStatusByUserId(UserIdStatus userIdStatus);

}
