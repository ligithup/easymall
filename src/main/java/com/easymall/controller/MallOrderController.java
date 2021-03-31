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
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/selectMallOrderAll")
    @ApiOperation(value="查询全部订单信息", notes="查询全部订单信息")
    public TableDataInfo selectMallOrderAll(Integer pageNum, Integer pageSize){
        startPage();
        List<MallOrderPOJO> mallOrderList=mallOrderService.selectMallOrderAll();
        return getDataTable(mallOrderList);
    }

    @GetMapping("/selectMallOrderByUserId")
    @ApiOperation(value="通过用户ID查询订单信息", notes="通过用户ID查询订单信息")
    public TableDataInfo selectMallOrderByUserId(Integer pageNum, Integer pageSize,String userId){
        startPage();
        List<MallOrderPOJO> mallOrderList=mallOrderService.selectMallOrderByUserId(userId);
        return getDataTable(mallOrderList);
    }
    @GetMapping("/selectMallOrderByOrderId")
    @ApiOperation(value="通过订单ID查询订单信息", notes="通过订单ID查询订单信息")
    public ResultUtil selectMallOrderByOrderId(String orderId){

        MallOrderPOJO mallOrder=mallOrderService.selectMallOrderByOrderId(orderId);

        return ResultUtil.success(mallOrder);
    }


    @PostMapping(value = "insertMallOrder",produces ="application/json;charset=utf-8" )
    @ApiOperation(value="添加订单信息", notes="添加订单信息")
    public ResultUtil insertMallOrder(@RequestBody List<MallOrderPOJO> mallOrderList){

       List<MallOrderPOJO> i =mallOrderService.insertMallOrder(mallOrderList);
//        if(i==0){
//            return  ResultUtil.result("添加失败");
//        }
        return  ResultUtil.success(i);
    }
    @PostMapping(value = "updateMallOrder",produces ="application/json;charset=utf-8" )
    @ApiOperation(value="修改订单信息", notes="修改订单信息")
    public ResultUtil updateMallOrder(@RequestBody MallOrderPOJO mallOrder){

        int i =mallOrderService.updateMallOrder(mallOrder);
        if(i==0){
            return  ResultUtil.result("修改失败");
        }
        return  ResultUtil.success(i);
    }


    @GetMapping("/selectMallOrderItemByUserId")
    @ApiOperation(value="通过用户ID查询全部订单明细信息", notes="通过用户ID查询全部订单明细信息")
    public TableDataInfo selectMallOrderItemByUserId(Integer pageNum, Integer pageSize,String userId){
        startPage();
        List<MallOrderItemPOJO> mallOrderItemList=mallOrderService.selectMallOrderItemByUserId(userId);
        return getDataTable(mallOrderItemList);
    }

    @GetMapping("/selectMallOrderItemByOrderItemId")
    @ApiOperation(value="通过订单明细ID查询订单明细信息", notes="通过订单明细ID查询订单明细信息")
    public ResultUtil selectMallOrderItemByOrderItemId(String orderItemId){

        MallOrderItemPOJO mallOrderItem=mallOrderService.selectMallOrderItemByOrderItemId(orderItemId);
        return ResultUtil.success(mallOrderItem);
    }

    @GetMapping("/selectMallOrderItemByOrderId")
    @ApiOperation(value="通过订单ID查询订单明细信息", notes="通过订单ID查询订单明细信息")
    public TableDataInfo selectMallOrderItemByOrderId(Integer pageNum, Integer pageSize,String orderId){
        startPage();
        List<MallOrderItemPOJO> mallOrderItemList=mallOrderService.selectMallOrderItemByOrderId(orderId);
        return getDataTable(mallOrderItemList);
    }

    @PostMapping(value = "insertMallOrderItem",produces ="application/json;charset=utf-8" )
    @ApiOperation(value="添加订单明细信息", notes="添加订单明细信息")
    public ResultUtil insertMallOrderItem(@RequestBody List<MallOrderItemPOJO> mallOrderItemList){

        int i =mallOrderService.insertMallOrderItem(mallOrderItemList);
        if(i==0){
            return  ResultUtil.result("添加失败");
        }
        return  ResultUtil.success(i);
    }
    @PostMapping(value = "updateMallOrderItem",produces ="application/json;charset=utf-8" )
    @ApiOperation(value="修改订单明细信息", notes="修改订单明细信息")
    public ResultUtil updateMallOrderItem(@RequestBody MallOrderItemPOJO mallOrderItem){

        int i =mallOrderService.updateMallOrderItem(mallOrderItem);
        if(i==0){
            return  ResultUtil.result("修改失败");
        }
        return  ResultUtil.success(i);
    }

    @PostMapping(value = "deleteMallOrderItemByOrderItemIds",produces ="application/json;charset=utf-8" )
    @ApiOperation(value="通过订单明细ID删除订单明细信息", notes="通过订单明细ID删除订单明细信息")
    public ResultUtil deleteMallOrderItemByOrderIds(@RequestBody String[] orderItemIds){

        int i=mallOrderService.deleteMallOrderItemByOrderItemIds(orderItemIds);
        if(i==0){
            return  ResultUtil.result("删除失败");
        }
        return  ResultUtil.success(i);
    }

    @PostMapping(value = "deleteMallOrderByOrderIds",produces ="application/json;charset=utf-8" )
    @ApiOperation(value="通过订单ID删除订单明细信息", notes="通过订单ID删除订单明细信息")
    public ResultUtil deleteMallOrderByOrderIds(@RequestBody String[] orderIds){

        int i=mallOrderService.deleteMallOrderByOrderIds(orderIds);
        if(i==0){
            return  ResultUtil.result("删除失败");
        }
        return  ResultUtil.success(i);
    }

}
