package com.easymall.service;

import com.easymall.mapper.SysUserMapper;
import com.easymall.pojo.SysUserPOJO;
import com.easymall.pojo.UserIdStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author liweijun
 * @Date 2021/3/6
 * @description：
 **/
@Service
public class SysUserService {

    @Resource
    SysUserMapper sysUserMapper;

    public void addUser(SysUserPOJO sysUserPOJO) {
        sysUserMapper.addUser(sysUserPOJO);
    }

    public SysUserPOJO login(String loginName, String password,String userType) {

        return sysUserMapper.login(loginName,password,userType);
    }

    public List<SysUserPOJO> selectUser() {


        return sysUserMapper.selectUser();
    }

    public SysUserPOJO selectUserByLoginName(String loginName) {

        return sysUserMapper.selectUserByLoginName(loginName);
    }

    public List<SysUserPOJO> selectUserByUserName(String userName) {

        return sysUserMapper.selectUserByUserName(userName);
    }

    public int deleteUserByUserId(String[] userIds) {

        return sysUserMapper.deleteUserByUserId(userIds);
    }

    public int updateUserByUserId(SysUserPOJO sysUserPOJO) {

        return  sysUserMapper.updateUserByUserId(sysUserPOJO);
    }

    public int updateUserStatusByUserId(UserIdStatus userIdStatus) {
        return  sysUserMapper.updateUserStatusByUserId(userIdStatus);
    }
}
