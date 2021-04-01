package com.easymall.controller;

import com.easymall.base.BaseController;
import com.easymall.page.TableDataInfo;
import com.easymall.pojo.LoginVO;
import com.easymall.pojo.SysUserPOJO;
import com.easymall.service.SysUserService;
import com.easymall.util.EncryptUtil;
import com.easymall.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping(value = "addUser",produces ="application/json;charset=utf-8" )
    @ApiOperation(value="注册用户", notes="注册用户")
    public ResultUtil addUser(@RequestBody SysUserPOJO sysUserPOJO){

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



    @PostMapping(value = "login",produces ="application/json;charset=utf-8" )
    @ApiOperation(value="用户登录", notes="用户登录")
    public  ResultUtil  login(@RequestBody LoginVO loginVO){
        if(loginVO==null||loginVO.getLoginName()==null||loginVO.getPassword()==null){
            return ResultUtil.result("账号或密码为空");
        }
        String md5Password = EncryptUtil.getMD5Str(loginVO.getPassword());
        //MD5加密后和数据库password对比
        SysUserPOJO user =sysUserService.login(loginVO.getLoginName(),md5Password,loginVO.getUserType());
        if(user==null){
           return ResultUtil.result("密码错误");
        }

        return  ResultUtil.success(user);
    }


    @GetMapping("selectUser")
    @ApiOperation(value="查询全部用户", notes="查询全部用户")
    public TableDataInfo selectUser(Integer pageNum, Integer pageSize){
        startPage();
        List<SysUserPOJO> userList=sysUserService.selectUser();
        return getDataTable(userList);
    }

    @GetMapping("selectUserByLoginName")
    @ApiOperation(value="通过登录名查询用户", notes="通过登录名查询用户")
    public  ResultUtil  selectUserByLoginName(String loginName){
        SysUserPOJO user =sysUserService.selectUserByLoginName(loginName);
        return  ResultUtil.success(user);
    }

    @GetMapping("selectUserByUserName")
    @ApiOperation(value="通过用户名模糊查询用户", notes="通过用户名模糊查询用户")
    public  TableDataInfo  selectUserByUserName(Integer pageNum, Integer pageSize,String userName){
        startPage();
        List<SysUserPOJO> userList =sysUserService.selectUserByUserName(userName);
        return getDataTable(userList);
    }


    @PostMapping(value = "deleteUserByUserId" ,produces ="application/json;charset=utf-8" )
    @ApiOperation(value="通过用户id删除用户", notes="通过用户id删除用户")
    public ResultUtil deleteUserByUserId(@RequestBody String  userIds){
        String[] split = userIds.split(",");
        int i= sysUserService.deleteUserByUserId(split);
        if(i==0){
            return  ResultUtil.result("删除失败");
        }
        return  ResultUtil.success(i);
    }

    @PostMapping(value = "updateUserByUserId",produces ="application/json;charset=utf-8" )
    @ApiOperation(value="通过UserId修改用户信息", notes="通过UserId修改用户信息")
    public ResultUtil updateUserByUserId(@RequestBody SysUserPOJO sysUserPOJO){

        int i=sysUserService.updateUserByUserId(sysUserPOJO);
        if(i==0){
            return  ResultUtil.result("修改失败");
        }
        return  ResultUtil.success(i);
    }

}
