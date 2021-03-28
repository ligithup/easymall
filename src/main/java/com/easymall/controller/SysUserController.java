package com.easymall.controller;

import com.easymall.base.BaseController;
import com.easymall.page.TableDataInfo;
import com.easymall.pojo.SysUserPOJO;
import com.easymall.service.SysUserService;
import com.easymall.util.EncryptUtil;
import com.easymall.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author liweijun
 * @Date 2021/3/6
 * @description：
 **/
@RestController
@RequestMapping("/sysUser")
@Slf4j
@Api(value = "用户接口",tags = "用户接口")
public class SysUserController extends BaseController {

    @Autowired
    SysUserService sysUserService;

    @PostMapping("/addUser")
    @ApiOperation(value="注册用户", notes="注册用户")
    public ResultUtil addUser(SysUserPOJO sysUserPOJO){

        if(!ObjectUtils.isEmpty(sysUserPOJO)){
            SysUserPOJO user =sysUserService.selectUserByLoginName(sysUserPOJO.getLoginName());
            if(user!=null){
                return  ResultUtil.result("用户名已存在");
            }
            //密码MD5加密
            String md5Password = EncryptUtil.getMD5Str(sysUserPOJO.getPassword());
            sysUserPOJO.setPassword(md5Password);
            sysUserService.addUser(sysUserPOJO);
        }

        return ResultUtil.success();
    }

    @PostMapping("login")
    @ApiOperation(value="用户登录", notes="用户登录")
    public  ResultUtil  login(String loginName,String password){
        String md5Password = EncryptUtil.getMD5Str(password);
        //MD5加密后和数据库password对比
        SysUserPOJO user =sysUserService.login(loginName,md5Password);
        if(user==null){
           return ResultUtil.result("密码错误");
        }

        return  ResultUtil.success(user);
    }

    @PostMapping("selectUser")
    @ApiOperation(value="查询全部用户", notes="查询全部用户")
    public TableDataInfo selectUser(Integer pageNum, Integer pageSize){
        startPage();
        List<SysUserPOJO> userList=sysUserService.selectUser();
        return getDataTable(userList);
    }

    @PostMapping("selectUserByLoginName")
    @ApiOperation(value="通过登录名查询用户", notes="通过登录名查询用户")
    public  ResultUtil  selectUserByLoginName(String loginName){
        SysUserPOJO user =sysUserService.selectUserByLoginName(loginName);
        return  ResultUtil.success(user);
    }

    @PostMapping("selectUserByUserName")
    @ApiOperation(value="通过用户名模糊查询用户", notes="通过用户名模糊查询用户")
    public  TableDataInfo  selectUserByUserName(Integer pageNum, Integer pageSize,String userName){
        startPage();
        List<SysUserPOJO> userList =sysUserService.selectUserByUserName(userName);
        return getDataTable(userList);
    }

    @PostMapping("deleteUserByUserId")
    @ApiOperation(value="通过用户id删除用户", notes="通过用户id删除用户")
    public ResultUtil deleteUserByUserId(@RequestBody String[] userIds){

        int i= sysUserService.deleteUserByUserId(userIds);
        if(i==0){
            return  ResultUtil.result("删除失败");
        }
        return  ResultUtil.success(i);
    }


}
