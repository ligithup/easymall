package com.easymall.controller;

import com.easymall.base.BaseController;
import com.easymall.page.TableDataInfo;
import com.easymall.pojo.MallOrderItemPOJO;
import com.easymall.pojo.MallOrderPOJO;
import com.easymall.service.MallOrderService;
import com.easymall.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author liweijun
 * @Date 2021/3/9
 * @description：
 **/
@RestController
@RequestMapping("/Order")
@Slf4j
@Api(value = "订单接口",tags = "订单接口")
public class MallOrderController extends BaseController {

    @Autowired
    MallOrderService mallOrderService;

    @PostMapping("/selectMallOrderAll")
    @ApiOperation(value="查询全部订单信息", notes="查询全部订单信息")
    public TableDataInfo selectMallOrderAll(Integer pageNum, Integer pageSize){
        startPage();
        List<MallOrderPOJO> mallOrderList=mallOrderService.selectMallOrderAll();
        return getDataTable(mallOrderList);
    }

    @PostMapping("/selectMallOrderByUserId")
    @ApiOperation(value="通过用户ID查询订单信息", notes="通过用户ID查询订单信息")
    public TableDataInfo selectMallOrderByUserId(Integer pageNum, Integer pageSize,String userId){
        startPage();
        List<MallOrderPOJO> mallOrderList=mallOrderService.selectMallOrderByUserId(userId);
        return getDataTable(mallOrderList);
    }



    @PostMapping("/insertMallOrder")
    @ApiOperation(value="添加订单信息", notes="添加订单信息")
    public ResultUtil insertMallOrder(@RequestBody List<MallOrderPOJO> mallOrderList){

        int i =mallOrderService.insertMallOrder(mallOrderList);
        if(i==0){
            return  ResultUtil.result("添加失败");
        }
        return  ResultUtil.success(i);
    }
    @PostMapping("/updateMallOrder")
    @ApiOperation(value="修改订单信息", notes="修改订单信息")
    public ResultUtil updateMallOrder(MallOrderPOJO mallOrder){

        int i =mallOrderService.updateMallOrder(mallOrder);
        if(i==0){
            return  ResultUtil.result("修改失败");
        }
        return  ResultUtil.success(i);
    }


    @PostMapping("/selectMallOrderItemByUserId")
    @ApiOperation(value="通过用户ID查询全部订单明细信息", notes="通过用户ID查询全部订单明细信息")
    public TableDataInfo selectMallOrderItemByUserId(Integer pageNum, Integer pageSize,String userId){
        startPage();
        List<MallOrderItemPOJO> mallOrderItemList=mallOrderService.selectMallOrderItemByUserId(userId);
        return getDataTable(mallOrderItemList);
    }

    @PostMapping("/selectMallOrderItemByOrderId")
    @ApiOperation(value="通过订单ID查询订单明细信息", notes="通过订单ID查询订单明细信息")
    public TableDataInfo selectMallOrderItemByOrderId(Integer pageNum, Integer pageSize,String orderId){
        startPage();
        List<MallOrderItemPOJO> mallOrderItemList=mallOrderService.selectMallOrderItemByOrderId(orderId);
        return getDataTable(mallOrderItemList);
    }

    @PostMapping("/insertMallOrderItem")
    @ApiOperation(value="添加订单明细信息", notes="添加订单明细信息")
    public ResultUtil insertMallOrderItem(@RequestBody List<MallOrderItemPOJO> mallOrderItemList){

        int i =mallOrderService.insertMallOrderItem(mallOrderItemList);
        if(i==0){
            return  ResultUtil.result("添加失败");
        }
        return  ResultUtil.success(i);
    }
    @PostMapping("/updateMallOrderItem")
    @ApiOperation(value="修改订单明细信息", notes="修改订单明细信息")
    public ResultUtil updateMallOrderItem(MallOrderItemPOJO mallOrderItem){

        int i =mallOrderService.updateMallOrderItem(mallOrderItem);
        if(i==0){
            return  ResultUtil.result("修改失败");
        }
        return  ResultUtil.success(i);
    }

    @PostMapping("/deleteMallOrderItemByOrderItemIds")
    @ApiOperation(value="通过订单明细ID删除订单明细信息", notes="通过订单明细ID删除订单明细信息")
    public ResultUtil deleteMallOrderItemByOrderIds(String[] orderItemIds){

        int i=mallOrderService.deleteMallOrderItemByOrderItemIds(orderItemIds);
        if(i==0){
            return  ResultUtil.result("删除失败");
        }
        return  ResultUtil.success(i);
    }

    @PostMapping("/deleteMallOrderByOrderIds")
    @ApiOperation(value="通过订单ID删除订单明细信息", notes="通过订单ID删除订单明细信息")
    public ResultUtil deleteMallOrderByOrderIds(String[] orderIds){

        int i=mallOrderService.deleteMallOrderByOrderIds(orderIds);
        if(i==0){
            return  ResultUtil.result("删除失败");
        }
        return  ResultUtil.success(i);
    }

}
