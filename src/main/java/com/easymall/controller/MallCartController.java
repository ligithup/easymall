package com.easymall.controller;

import com.easymall.base.BaseController;
import com.easymall.page.TableDataInfo;
import com.easymall.pojo.CartIds;
import com.easymall.pojo.MallCartPOJO;
import com.easymall.service.MallCartService;
import com.easymall.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author liweijun
 * @Date 2021/3/9
 * @description：
 **/
@RestController
@RequestMapping("/Cart")
@Slf4j
@Api(value = "购物车接口",tags = "购物车接口")
public class MallCartController extends BaseController {

    @Autowired
    MallCartService mallCartService;

    @GetMapping("/selectMallCartByUserId")
    @ApiOperation(value="通过用户ID查询购物车", notes="通过用户ID查询购物车")
    public TableDataInfo selectMallCartByUserId(Integer pageNum, Integer pageSize, String userId){
        startPage();
        List<MallCartPOJO> mallCartList=mallCartService.selectMallCartByUserId(userId);
        return getDataTable(mallCartList);
    }

    @PostMapping(value = "insertMallCart",produces ="application/json;charset=utf-8" )
    @ApiOperation(value="添加购物车", notes="添加购物车")
    public ResultUtil  insertMallCart(@RequestBody List<MallCartPOJO> mallCartList){

        int i=mallCartService.insertMallCart(mallCartList);
        if(i==0){
            return  ResultUtil.result("添加失败");
        }
        return  ResultUtil.success(i);
    }

    @PostMapping(value = "deleteMallCartByCartIds",produces ="application/json;charset=utf-8" )
    @ApiOperation(value="通过CartId删除购物车商品", notes="通过CartId删除购物车商品")
    public ResultUtil  deleteMallCartByCartIds(@RequestBody CartIds cartIds){
        String[] split = cartIds.getCartIds().split(",");
        int i=mallCartService.deleteMallCartByCartIds(split);
        if(i==0){
            return  ResultUtil.result("删除失败");
        }
        return  ResultUtil.success(i);
    }

    @GetMapping("/updateMallCartByCartId")
    @ApiOperation(value="通过CartId修改购物车商品", notes="通过CartId修改购物车商品")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "cartId", value = "cartId", required = false, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "checked", value = "是否选择,1=已勾选,0=未勾选", required = false, dataType = "String")
    })
    public ResultUtil  updateMallCartByCartId(String cartId,String checked){
        int i=mallCartService.updateMallCartByCartId(cartId,checked);
        if(i==0){
            return  ResultUtil.result("修改失败");
        }
        return  ResultUtil.success(i);
    }

}
